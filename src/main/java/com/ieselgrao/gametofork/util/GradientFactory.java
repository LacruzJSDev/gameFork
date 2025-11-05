package com.ieselgrao.gametofork.util;

import javafx.scene.paint.*;
import java.util.Random;

/**
 * Utilidad para generar degradados aleatorios para rellenar círculos.
 * Se mantiene separada de la lógica del juego para facilitar pruebas y estilo.
 */
public final class GradientFactory {

    private GradientFactory() { /* util class */ }

    /**
     * Crea un Paint (RadialGradient o LinearGradient) aleatorio usando el Random proporcionado.
     * @param random fuente de aleatoriedad (reutilizar la del controlador para reproducibilidad)
     * @return Paint para usar como fill en nodos JavaFX
     */
    public static Paint createRandomGradient(Random random) {
        // Colores base
        Color c1 = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        // Segunda tonalidad: variación en brillo para buen contraste
        double brightnessFactor = 0.6 + random.nextDouble() * 0.8; // 0.6 - 1.4
        Color c2 = c1.deriveColor(0, 1.0, brightnessFactor, 1.0);

        // Elegir tipo de degradado aleatoriamente
        if (random.nextBoolean()) {
            // RadialGradient: da un efecto de iluminación central más agradable en círculos
            double centerX = 0.3 + random.nextDouble() * 0.4; // 0.3 - 0.7
            double centerY = 0.3 + random.nextDouble() * 0.4;
            double radius = 0.6 + random.nextDouble() * 0.6; // 0.6 - 1.2 (proportional true tolerates >1)
            return new RadialGradient(
                    0, 0,
                    centerX, centerY,
                    radius,
                    true, // proportional
                    CycleMethod.NO_CYCLE,
                    new Stop(0, c1),
                    new Stop(1, c2)
            );
        } else {
            // LinearGradient: dirección aleatoria
            double angle = random.nextDouble() * Math.PI * 2;
            double sx = 0.5 + 0.5 * Math.cos(angle);
            double sy = 0.5 + 0.5 * Math.sin(angle);
            double ex = 0.5 - 0.5 * Math.cos(angle);
            double ey = 0.5 - 0.5 * Math.sin(angle);
            return new LinearGradient(
                    sx, sy,
                    ex, ey,
                    true, // proportional
                    CycleMethod.NO_CYCLE,
                    new Stop(0, c1),
                    new Stop(1, c2)
            );
        }
    }
}
