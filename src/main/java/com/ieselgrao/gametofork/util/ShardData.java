package com.ieselgrao.gametofork.util;

/**
 * Datos simples para controlar la física de un trozo (shard) creado al romper un círculo.
 */
public class ShardData {
    public double vx;
    public double vy;

    public ShardData(double vx, double vy) {
        this.vx = vx;
        this.vy = vy;
    }
}
