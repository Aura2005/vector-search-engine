package com.vse.store;


class InvalidCapacity extends RuntimeException {
    public InvalidCapacity(String message) {
        super(message);
    }
}

//min heap
public class VectorHeap {
    private final float[] heap;
    private int size;

    VectorHeap(int k) {
        if(k < 1) throw new InvalidCapacity("can't do top 0 or top < 0 check");
        this.heap = new float[k];
        this.size = 0;
    }

    private int parent(int index) {
        return (index-1)/2;
    }

    private int left(int index) {
        return index*2+1;
    }

    private int right(int index) {
        return index*2+2;
    }

    private void swap(int i1, int i2) {
        float temp = this.heap[i1];
        this.heap[i1] = this.heap[i2];
        this.heap[i2] = temp;
    }

    public void insert(float value) {
        if(this.size < heap.length) {
            this.heap[this.size] = value;
            this.size++;
            this.upHeap(this.size-1);
        } else {
            if(this.heap[0] < value) {
                this.heap[0] = value;
                this.downHeap(0);
            }
        }
    }

    private void downHeap(int index) {
        int minIndex = index;
        int leftIndex = this.left(index);
        int rightIndex = this.right(index);
        if(leftIndex < this.heap.length && this.heap[leftIndex] < this.heap[minIndex]) {
            minIndex = leftIndex;
        }
        if(rightIndex < this.heap.length && this.heap[rightIndex] < this.heap[minIndex]) {
            minIndex = rightIndex;
        }
        if(minIndex != index) {
            this.swap(index, minIndex);
            this.downHeap(minIndex);
        }
    }

    private void upHeap(int index) {
        if(index == 0) return;
        if(this.heap[this.parent(index)] > this.heap[index]) {
            this.swap(this.parent(index), index);
            this.upHeap(this.parent(index));
        }
    }
}
