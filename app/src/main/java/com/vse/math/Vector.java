package com.vse.math;

public class Vector {
    private static final int DEFAULT_DIMENSIONS = 256;
    private final int dimensions;
    private final float[] coordinates;
    private final float magnitude;

    Vector() {
        this.dimensions = DEFAULT_DIMENSIONS;
        this.coordinates = new float[this.dimensions];
        this.magnitude = 0.0f;
    }

    Vector(float... args) {
        this.dimensions = args.length;
        this.coordinates = new float[this.dimensions];
        System.arraycopy(args, 0, this.coordinates, 0, args.length);
        this.magnitude = this.magnitude();
    }

    public int getDimensions() {
        return this.dimensions;
    }

    public float[] getCoordinates() {
        return this.coordinates;
    }

    public float getMagnitude() {
        return this.magnitude;
    }

    private float magnitude() {
        float sum = 0;
        for(int i = 0; i < this.dimensions; i++) {
            sum += this.coordinates[i]*this.coordinates[i];
        }
        return (float)Math.sqrt(sum);
    }

    public Vector unit() {
        if(this.magnitude == 0) throw new ArithmeticException("Undefined unit vector for zero vector");

        float[] unitCoordinates = new float[this.dimensions];
        for(int i = 0; i < this.dimensions; i++) {
            unitCoordinates[i] = this.coordinates[i]/magnitude;
        }
        return new Vector(unitCoordinates);
    }

}