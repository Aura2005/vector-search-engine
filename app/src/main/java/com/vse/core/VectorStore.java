package com.vse.core;

import java.util.HashMap;

public interface VectorStore {
    void addVector(String id, float[] vector);

    float[] getVector(String id);

    float[] deleteVector(String id);


}
