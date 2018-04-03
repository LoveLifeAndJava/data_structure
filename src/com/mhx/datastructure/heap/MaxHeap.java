package com.mhx.datastructure.heap;

import java.util.Random;

/**
 * Max Heap
 *
 * @author MHX
 * @date 2018/4/3
 */
public class MaxHeap<T extends Comparable<T>> {
    private T[] data;
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        data = (T[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(T arr[]) {
        data = (T[]) new Comparable[arr.length + 1];
        capacity = arr.length;
        for (int i = 0; i < arr.length; ++i) {
            data[i + 1] = arr[i];
        }
        count = arr.length;
        for (int i = count / 2; i >= 1; --i) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    void insert(T item) {
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    T popMax() {
        assert count > 0;
        T temp = data[1];
        data[1] = data[count]; // swap?
        count--;
        shiftDown(1);
        return temp;
    }

    private void shiftUp(int k) {
        // when k == 2, compares with 1, so k should be greater than 1.
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(data, k / 2, k);
            k /= 2;
        }
    }

    private void shiftDown(int k) {
        // has children
        while (k * 2 <= count) {
            int swapIndex = k * 2;
            // has both children, and right > left
            if (k * 2 + 1 <= count && data[k * 2].compareTo(data[k * 2 + 1]) < 0) {
                swapIndex += 1;
            }
            if (data[k].compareTo(data[swapIndex]) >= 0) {
                break;
            }
            swap(data, swapIndex, k);
            k = swapIndex;
        }
    }

    private void swap(T[] nums, int i, int j) {
        T temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        Random random = new Random();
        Integer[] randomArr = new Integer[15];
        for (int i = 0; i < 15; i++) {
            int element = random.nextInt(100);
            System.out.print(element + ",");
            randomArr[i] = element;
        }

        MaxHeap<Integer> maxHeap1 = new MaxHeap<>(100);
        for (Integer e : randomArr) {
            maxHeap1.insert(e);
        }

        System.out.println();

        for (int i = 0; i < 15; i++) {
            System.out.print(maxHeap1.popMax() + ",");
        }

        System.out.println();

        MaxHeap<Integer> maxHeap2 = new MaxHeap<>(randomArr);
        for (int i = 0; i < 15; i++) {
            System.out.print(maxHeap2.popMax() + ",");
        }
    }
}
