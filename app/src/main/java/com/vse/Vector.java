package com.vse;

public class Vector {
    private final float[] coordinates;
    private final float magnitude;
    private final float[] unit;

    private Vector() {
        throw new IllegalStateException();
    }

    public Vector(float... args) {
        if(args.length == 0) throw new IllegalArgumentException();
        float sum = 0;
        for(float v : args) sum += v*v;
        if(sum == 0) throw new ArithmeticException();
        this.magnitude = (float)Math.sqrt(sum);
        this.coordinates = args.clone();
        float u = 1f/this.magnitude;
        this.unit = new float[this.coordinates.length];
        for(int i = 0; i < this.coordinates.length; i++) this.unit[i] = this.coordinates[i]*u;
    }

    public float get(int index) {
        return this.coordinates[index];
    }

    public float getUnit(int index) {
        return this.unit[index];
    }

    public float getMagnitude() {
        return this.magnitude;
    }

    public int getDimensions() {
        return this.coordinates.length;
    }

    public float[] coordinates() {
        return this.coordinates;
    }

    public float[] unit() {
        return this.unit;
    }

}