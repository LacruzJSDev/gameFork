package com.ieselgrao.gametofork.util;

import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Fábrica de partículas/trozos para el efecto de romper círculos.
 */
public final class ParticleFactory {

    private ParticleFactory() { /* util */ }

    /**
     * Crea una lista de pequeños círculos (shards) alrededor del punto dado.
     * Los shards contienen en userData una instancia de {@link ShardData} con su velocidad.
     * @param centerX posición X central (layoutX) del círculo original
     * @param centerY posición Y central (layoutY) del círculo original
     * @param fill Paint a usar para los shards (puede ser un degradado o color)
     * @param count número de shards a crear
     * @param random fuente de aleatoriedad
     * @return lista de Nodes (Circle) lista para añadir al Pane
     */
    /**
     * Crea shards cuyo número y velocidad dependen del radio del círculo original.
     * @param centerX posición X
     * @param centerY posición Y
     * @param fill Paint del círculo original
     * @param baseCount número base de shards (se escala con radius)
     * @param radius radio del círculo original
     * @param random fuente de aleatoriedad
     */
    public static List<Node> createShards(double centerX, double centerY, Paint fill, int baseCount, double radius, Random random) {
        List<Node> out = new ArrayList<>();

        // Escala el número de shards con el radio (más grande -> más shards)
        int count = Math.max(6, (int) (baseCount * (radius / 10.0)));

        // Explosion strength: mayor radio => mayor separación
        double strength = 1.0 + (radius / 10.0);

        for (int i = 0; i < count; i++) {
            double r = Math.max(1.5, radius * (0.08 + random.nextDouble() * 0.10)); // trozos proporcionales
            Circle s = new Circle(r);

            // posición inicial: pequeños offsets alrededor del centro
            double ox = (random.nextDouble() - 0.5) * radius * 0.6;
            double oy = (random.nextDouble() - 0.5) * radius * 0.6;
            s.setLayoutX(centerX + ox);
            s.setLayoutY(centerY + oy);
            s.setFill(fill);

            // velocidades iniciales: impulso radial más notorio
            double angle = random.nextDouble() * Math.PI * 2;
            double speed = (0.8 + random.nextDouble() * 1.8) * strength; // base 0.8-2.6 multiplicado por strength
            double vx = Math.cos(angle) * speed;
            double vy = Math.sin(angle) * speed * 0.6; // menos impulso vertical inicial

            // Aumentamos vy para que caigan con más separación
            vy = vy - (0.5 + random.nextDouble() * 1.0);

            s.setUserData(new ShardData(vx, vy));
            s.setMouseTransparent(true);
            out.add(s);
        }
        return out;
    }
}
