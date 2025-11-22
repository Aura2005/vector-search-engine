package com.vse.store;

import java.util.HashMap;
import com.vse.core.VectorStore;

public class InMemoryVectorStore implements VectorStore {
    HashMap<String, float[]> store;

    InMemoryVectorStore() {
        this.store = new HashMap<>();
    }

    @Override
    public void addVector(String id, float[] vector) {
        store.put(id, vector);
    }

    @Override
    public float[] getVector(String id) {
        return store.get(id);
    }

    @Override
    public float[] deleteVector(String id) {
        return store.remove(id);
    }

}
