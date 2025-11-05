package com.ieselgrao.gametofork.controller;

import com.ieselgrao.gametofork.model.GameModel;
import com.ieselgrao.gametofork.MainApplication;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import com.ieselgrao.gametofork.util.GradientFactory;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.ieselgrao.gametofork.util.ParticleFactory;
import com.ieselgrao.gametofork.util.ShardData;

public class GameController {

    @FXML
    private Pane gamePane;
    @FXML
    private Label scoreLabel;
    @FXML
    private Label livesLabel;

    private GameModel model;
    private AnimationTimer gameLoop;
    private Random random = new Random();

    // Parámetros de los círculos
    private final double MIN_RADIUS = 10;
    private final double MAX_RADIUS = 30;
    private final double FALL_SPEED = 1;
    // Parámetros de partículas
    private final double GRAVITY = 0.25; // aceleración hacia abajo para shards
    private final double AIR_RESISTANCE = 0.995; // ligera reducción de vx
    private final double LOST_LINE_Y = 550; // Línea cerca del pie de la ventana (600px)

    @FXML
    public void initialize() {
        model = MainApplication.getGameModel();

        // Bindeo de etiquetas a las propiedades del modelo
        scoreLabel.textProperty().bind(model.scoreProperty().asString("Puntuación: %d"));
        livesLabel.textProperty().bind(model.livesProperty().asString("Vidas: %d"));

        // Dibuja la línea roja de pérdida de vida
        Line lossLine = new Line(0, LOST_LINE_Y, gamePane.getWidth(), LOST_LINE_Y);
        lossLine.setStroke(Color.RED);
        lossLine.setStrokeWidth(2);
        gamePane.getChildren().add(lossLine);

        // Inicia el ciclo del juego
        startGameLoop();
    }

    private void startGameLoop() {
        gameLoop = new AnimationTimer() {
            private long lastSpawnTime = 0;
            private final long SPAWN_INTERVAL_NS = 1_000_000_000L; // Spawn cada 1 segundo

            @Override
            public void handle(long now) {
                // Generar nuevos círculos
                if (now - lastSpawnTime > SPAWN_INTERVAL_NS) {
                    createRandomCircle();
                    lastSpawnTime = now;
                }

                // Actualizar posición y revisar colisiones
                updateCircles();

                // Revisar fin del juego
                if (model.isGameOver()) {
                    stop();
                    try {
                        MainApplication.switchToGameOverView();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        gameLoop.start();
    }

    private void createRandomCircle() {
        double radius = MIN_RADIUS + (MAX_RADIUS - MIN_RADIUS) * random.nextDouble();
        double x = radius + (random.nextDouble() * (gamePane.getWidth() - 2 * radius));

    Circle circle = new Circle(radius);
    // Usa un degradado generado por la fábrica para un efecto más atractivo
    circle.setFill(GradientFactory.createRandomGradient(random));
    circle.setLayoutX(x);
    circle.setLayoutY(-radius); // Inicia fuera de la parte superior

        // Asigna puntos según el tamaño (círculos más pequeños dan más puntos)
        int points = (int) (MAX_RADIUS - radius + 1);
        circle.setUserData(points);

        // Evento de click: romper en shards y sumar puntos
        circle.setOnMouseClicked(event -> {
            // Añade puntuación
            model.addScore((int) circle.getUserData());

            // Crear shards usando el radio del círculo para escalar la explosión
            List<javafx.scene.Node> shards = ParticleFactory.createShards(
                    circle.getLayoutX(),
                    circle.getLayoutY(),
                    circle.getFill(),
                    12,
                    circle.getRadius(),
                    random
            );
            gamePane.getChildren().addAll(shards);

            // Eliminar el círculo original
            gamePane.getChildren().remove(circle);
            event.consume();
        });

        gamePane.getChildren().add(circle);
    }

    private void updateCircles() {
        List<javafx.scene.Node> toRemove = new ArrayList<>();
        List<javafx.scene.Node> toAdd = new ArrayList<>();

        for (javafx.scene.Node node : List.copyOf(gamePane.getChildren())) {
            if (!(node instanceof Circle circle)) continue;

            Object ud = circle.getUserData();
            // Círculos principales: userData es Integer con puntos
            if (ud instanceof Integer) {
                circle.setLayoutY(circle.getLayoutY() + FALL_SPEED);

                if (circle.getLayoutY() > LOST_LINE_Y) {
                    // Romper en trozos
                    model.loseLife();
                    toRemove.add(circle);
                    // crear shards y añadirlos después del bucle
                    toAdd.addAll(ParticleFactory.createShards(circle.getLayoutX(), LOST_LINE_Y, circle.getFill(), 12, circle.getRadius(), random));
                }
            } else if (ud instanceof ShardData sd) {
                // Actualiza física simple para shards
                sd.vy += GRAVITY;
                sd.vx *= AIR_RESISTANCE;
                circle.setLayoutX(circle.getLayoutX() + sd.vx);
                circle.setLayoutY(circle.getLayoutY() + sd.vy);

                // Si alcanzan el suelo (línea de pérdida), se quedan ahí (acumulan)
                if (circle.getLayoutY() > LOST_LINE_Y) {
                    circle.setLayoutY(LOST_LINE_Y);
                    sd.vx = 0;
                    sd.vy = 0;
                }
            }
        }

        if (!toRemove.isEmpty()) gamePane.getChildren().removeAll(toRemove);
        if (!toAdd.isEmpty()) gamePane.getChildren().addAll(toAdd);
    }
}