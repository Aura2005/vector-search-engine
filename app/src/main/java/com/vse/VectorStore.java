package com.vse;

public class VectorStore {

    private static final int MAX_CAPACITY = 3000;
    private static final Vector[] vectors = new Vector[VectorStore.MAX_CAPACITY];
    private static final String[] ids = new String[VectorStore.MAX_CAPACITY];
    private static int size = 0;
    
    private VectorStore() {
        
    }

    public static int getSize() {
        return VectorStore.size;
    }

    public static void loadStore() {
        //This method will initialize the stored vectors (in disk) into memory by running append method from 0 to size
    }

    public static void append(String id, Vector vector) {
        if(VectorStore.size == VectorStore.MAX_CAPACITY) throw new IndexOutOfBoundsException();
        VectorStore.vectors[VectorStore.size] = vector;
        VectorStore.ids[VectorStore.size] = id;
        VectorStore.size++;
    }

    public static Vector getVector(int index) {
        if(index < 0 || index >= VectorStore.MAX_CAPACITY) throw new IndexOutOfBoundsException();
        return VectorStore.vectors[index];
    }

    public static String getId(int index) {
        if(index < 0 || index >= VectorStore.MAX_CAPACITY) throw new IndexOutOfBoundsException();
        return VectorStore.ids[index];
    }
}
