package com.vse.store;

import java.util.HashMap;
import com.vse.core.VectorStore;
import com.vse.math.Vector;

public class InMemoryVectorStore {
    HashMap<String, Vector> store;

    InMemoryVectorStore() {
        this.store = new HashMap<>();
    }


}
