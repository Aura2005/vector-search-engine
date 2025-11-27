package com.vse;

import com.vse.VectorUtils;
import java.util.ArrayList;
import java.util.HashMap;

public class VectorSearch {
    public static HashMap<Integer, Integer> topkIndex(int k, Vector input) {
        VectorHeap heap = new VectorHeap(k);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < VectorStore.getSize(); i++) {
            Vector current = VectorStore.getVector(i);
            float distance = VectorUtils.cosine(input, current);
            map.put(heap.insert(distance), i);
            
        }
        return map;
    }
}
