package com.nagrikar.algorithm;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class MinMaxHeap<T extends Comparable<T>> {
    private final List<T> heap;
    private final Type type;
    private int lastIndex;

    public MinMaxHeap(int size, Type type) {
        this.lastIndex = -1;
        this.heap = new ArrayList<>(size);
        LongStream.range(0, size).forEach(l -> this.heap.add(null));
        this.type = type;
    }

    public MinMaxHeap(T[] array, int size, Type type) {
        this.lastIndex = -1;
        this.heap = new ArrayList<>(size);
        LongStream.range(0, size).forEach(l -> this.heap.add(null));

        this.type = type;

        for (T anArray : array) {
            insert(anArray);
        }
    }

    public void addAll(T[] array) {
        for (T anArray : array) {
            insert(anArray);
        }
    }

    public MinMaxHeap insert(T data) {
        lastIndex++;
        heap.set(lastIndex, data);
        buildHeap(lastIndex);
        return this;
    }

    public MinMaxHeap delete() {
        heap.set(0, heap.get(lastIndex));
        heap.set(lastIndex, null);
        lastIndex--;
        heapify();
        return this;
    }

    public int size() {
        return this.lastIndex + 1;
    }

    private void buildHeap(int index) {
        int parentIndex;
        while (index >= 0 && Math.floor(index - 1) / 2 >= 0) {
            parentIndex = (index - 1) / 2;

            if (Type.MAXHEAP.equals(this.type) && heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else if (Type.MINHEAP.equals(this.type) && heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private List<T> getChildren(int index) {
        List<T> children = new ArrayList<>();
        T left = (2 * index) + 1 > lastIndex ? null : heap.get((2 * index) + 1);
        T right = (2 * index) + 2 > lastIndex ? null : heap.get((2 * index) + 2);
        children.add(left);
        children.add(right);
        return children;
    }

    private void heapify() {
        int index = 0;
        boolean done = false;
        T curr = heap.get(index);
        T left;
        T right;

        while (index <= lastIndex && !done) {
            List<T> children = getChildren(index);
            left = children.get(0);
            right = children.get(1);

            switch (this.type) {
                case MINHEAP:
                    if (right != null && curr.compareTo(right) > 0) {
                        if (left != null && right.compareTo(left) > 0) {
                            index = swapWithLeftChild(index);//change with left
                        } else {
                            index = swapWithRightChild(index);//change with right
                        }
                    } else if (left != null && curr.compareTo(left) > 0) {
                        index = swapWithLeftChild(index);//change with left
                    } else {
                        done = true;
                    }
                    break;

                case MAXHEAP:
                    if (right != null && curr.compareTo(right) < 0) {
                        if (left != null && right.compareTo(left) < 0) {
                            index = swapWithLeftChild(index);// change with left
                        } else {
                            index = swapWithRightChild(index);//change with right
                        }
                    } else if (left != null && curr.compareTo(left) < 0) {
                        index = swapWithLeftChild(index);//change with left
                    } else {
                        done = true;
                    }
                    break;

                default:
                    throw new IllegalArgumentException("Heap type should be 'min' or 'max'");
            }
        }
    }

    private int swapWithRightChild(int currIndex) {
        int targetIndex = (2 * currIndex) + 2;
        swap(currIndex, targetIndex);
        return targetIndex;
    }

    private int swapWithLeftChild(int currIndex) {
        int targetIndex = (2 * currIndex) + 1;
        swap(currIndex, targetIndex);
        return targetIndex;
    }

    private void swap(int currentIndex, int targetIndex) {
        T temp = heap.get(currentIndex);
        heap.set(currentIndex, heap.get(targetIndex));
        heap.set(targetIndex, temp);
    }

    public List<T> toList() {
        return ImmutableList.copyOf(heap.subList(0, size()));
    }

    /**
     * Type of Heap, namely MinHeap of MaxHeap.
     */
    public enum Type {
        MINHEAP, MAXHEAP
    }
}







