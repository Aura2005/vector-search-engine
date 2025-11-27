package com.vse;

class InvalidDimensions extends RuntimeException {
    public InvalidDimensions(String message) {
        super(message);
    }
}

public class VectorUtils {
    //distance between vectors (euclidean)
    public static float l2Distance(Vector v1, Vector v2) {
        return (float)Math.sqrt(VectorUtils.sqL2Distance(v1, v2));
    }   

    //cosine similarity
    public static float cosine(Vector v1, Vector v2) {
        if(v1.getMagnitude() == 0 || v2.getMagnitude() == 0) throw new ArithmeticException("Magnitude should be greater than zero");
        float sum = 0;
        float[] a = v1.unit();
        float[] b = v2.unit();
        for(int i = 0; i < v1.getDimensions(); i++) {
            sum += a[i]*b[i];
        }
        return sum;
    }

    //dot product
    public static float dot(Vector v1, Vector v2) {
        if(v1.getDimensions() != v2.getDimensions()) throw new InvalidDimensions("Unequal Dimensions");
        float sum = 0;
        float[] a = v1.coordinates();
        float[] b = v2.coordinates();
        for(int i = 0; i < v1.getDimensions(); i++) {
            sum += a[i]*b[i];
        }
        return sum;
    }

    //manhattan distance
    public static float l1Distance(Vector v1, Vector v2) {
        if(v1.getDimensions() != v2.getDimensions()) throw new InvalidDimensions("Unequal Dimensions");
        float sum = 0;
        float[] a = v1.coordinates();
        float[] b = v2.coordinates();
        for(int i = 0; i < v1.getDimensions(); i++) {
            sum += Math.abs(b[i]-a[i]);
        }
        return sum;
    }

    //squared euclidean
    public static float sqL2Distance(Vector v1, Vector v2) {
        if(v1.getDimensions() != v2.getDimensions()) throw new InvalidDimensions("Unequal Dimensions");
        float sum = 0;
        float[] a = v1.coordinates();
        float[] b = v2.coordinates();
        for(int i = 0; i < v1.getDimensions(); i++) {
            sum += (b[i]-a[i])*(b[i]-a[i]);
        }
        return sum;
    }

    //angular distance (0 to 180)
    public static float angleDistance(Vector v1, Vector v2) {
        return (float)(Math.acos(VectorUtils.cosine(v1, v2))*180/Math.PI);
    }
    
}
