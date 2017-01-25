package com.nagrikar.algorithm;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.google.common.collect.Lists.newArrayList;
import static com.nagrikar.algorithm.MinMaxHeap.Type.MAXHEAP;
import static com.nagrikar.algorithm.MinMaxHeap.Type.MINHEAP;
import static org.junit.Assert.assertEquals;

public class MinMaxHeapTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testBuildHeap() {
        MinMaxHeap<Integer> minHeap = new MinMaxHeap<>(3, MINHEAP);
        minHeap.addAll(new Integer[]{2, 3, 1});
        assertEquals(newArrayList(1, 3, 2), minHeap.toList());
    }

    @Test
    public void testInsert() {
        assertEquals(newArrayList(1, 3, 2, 4), new MinMaxHeap<>(new Integer[]{2, 3, 1}, 4, MINHEAP).insert(4).toList());
        assertEquals(newArrayList(-1, 1, 2, 4, 3), new MinMaxHeap<>(new Integer[]{1, 3, 2, 4}, 5, MINHEAP).insert(-1)
                .toList());
    }

    @Test
    public void testDelete() {
        assertEquals(newArrayList(2, 3), new MinMaxHeap<>(new Integer[]{2, 3, 1}, 3, MINHEAP).delete().toList());
        assertEquals(newArrayList(1L, 3L, 2L, 4L), new MinMaxHeap<>(new Long[]{-1L, 1L, 2L, 4L, 3L}, 5, MINHEAP)
                .delete().toList());
    }

    @Test
    public void testBuildMaxHeap() {
        assertEquals(newArrayList(3, 2, 1), new MinMaxHeap<>(new Integer[]{2, 3, 1}, 3, MAXHEAP).toList());
    }

    @Test
    public void testInsertMaxHeap() {
        assertEquals(newArrayList(4, 3, 1, 2), new MinMaxHeap<>(new Integer[]{3, 2, 1}, 4, MAXHEAP).insert(4)
                .toList());
        assertEquals(newArrayList(4, 3, 1, 2, -1), new MinMaxHeap<>(new Integer[]{4, 3, 1, 2}, 5, MAXHEAP)
                .insert(-1).toList());

    }

    @Test
    public void testDeleteMaxHeap() {
        assertEquals(new MinMaxHeap<>(new Integer[]{3, 2, 1}, 3, MAXHEAP).delete().toList(), newArrayList(2, 1));
        assertEquals(newArrayList(3, 2, 1, -1), new MinMaxHeap<>(new Integer[]{4, 3, 1, 2, -1}, 5, MAXHEAP)
                .delete().toList());
    }

    @Test
    public void testSwapWithRightChild() {
        assertEquals(newArrayList(2, 3, 6, 4, 5, 7), new MinMaxHeap<>(new Integer[]{1, 3, 2, 4, 5, 6, 7}, 7, MINHEAP)
                .delete()
                .toList());
        assertEquals(newArrayList(6, 4, 5, 3, 2, 1), new MinMaxHeap<>(new Integer[]{7, 4, 6, 3, 2, 1, 5}, 7, MAXHEAP)
                .delete().toList());
    }
}
