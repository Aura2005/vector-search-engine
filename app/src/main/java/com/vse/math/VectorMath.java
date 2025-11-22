package com.vse.math;

import com.vse.math.Vector;

class InvalidDimensions extends RuntimeException {
    public InvalidDimensions(String message) {
        super(message);
    }
}

public class VectorMath {
    //distance between vectors (euclidean)
    public static float l2Distance(Vector v1, Vector v2) {
        return (float)Math.sqrt(VectorMath.sqL2Distance(v1, v2));
    }   

    //cosine similarity
    public static float cosine(Vector v1, Vector v2) {
        if(v1.getMagnitude() == 0 || v2.getMagnitude() == 0) throw new ArithmeticException("Magnitude should be greater than zero");
        return VectorMath.dot(v1, v2)/(v1.getMagnitude()*v2.getMagnitude());
    }

    //dot product
    public static float dot(Vector v1, Vector v2) {
        if(v1.getDimensions() != v2.getDimensions()) throw new InvalidDimensions("Unequal Dimensions");
        float sum = 0;
        float[] v1Coord = v1.getCoordinates();
        float[] v2Coord = v2.getCoordinates();
        for(int i = 0; i < v1.getDimensions(); i++) {
            sum += v1Coord[i]*v2Coord[i];
        }
        return sum;
    }

    //manhattan distance
    public static float l1Distance(Vector v1, Vector v2) {
        if(v1.getDimensions() != v2.getDimensions()) throw new InvalidDimensions("Unequal Dimensions");
        float sum = 0;
        float[] v1Coord = v1.getCoordinates();
        float[] v2Coord = v2.getCoordinates();
        for(int i = 0; i < v1.getDimensions(); i++) {
            sum += Math.abs(v2Coord[i]-v1Coord[i]);
        }
        return sum;
    }

    //squared euclidean
    public static float sqL2Distance(Vector v1, Vector v2) {
        if(v1.getDimensions() != v2.getDimensions()) throw new InvalidDimensions("Unequal Dimensions");
        float sum = 0;
        float[] v1Coord = v1.getCoordinates();
        float[] v2Coord = v2.getCoordinates();
        for(int i = 0; i < v1.getDimensions(); i++) {
            sum += (v2Coord[i]-v1Coord[i])*(v2Coord[i]-v1Coord[i]);
        }
        return sum;
    }

    //angular distance (0 to 180)
    public static float angleDistance(Vector v1, Vector v2) {
        return (float)(Math.acos(VectorMath.cosine(v1, v2))*180/Math.PI);
    }
    
}
