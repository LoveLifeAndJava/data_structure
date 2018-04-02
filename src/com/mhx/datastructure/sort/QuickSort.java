package com.mhx.datastructure.sort;

import java.util.Arrays;

/**
 * @author MHX
 * @date 2018/4/1
 */
public class QuickSort {
    /**
     * range is [low, high]
     *
     * @param nums
     */
    public void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partitionOneWay2(nums, low, high);
        sort(nums, low, pivot - 1);
        sort(nums, pivot + 1, high);
    }

    /**
     * use tail recursion to optimize quick sort
     * range is [low, high]
     * change recursion to iteration
     *
     * @param nums
     */
    public void sortOptimzed(int[] nums, int low, int high) {
        while (low < high) {
            int pivot = partitionOneWay2(nums, low, high);
            sortOptimzed(nums, low, pivot - 1);
            low = pivot + 1;
        }
    }

    /**
     * do partitionTwoWay
     * dual-pivot quick sort
     * range is [low, high]
     *
     * @param nums
     * @param low
     * @param high
     * @return pivot
     */
    public int partitionTwoWay(int[] nums, int low, int high) {
        int pivotKey = nums[low];
        int i = low + 1;
        int j = high;
        while (true) {
            while (i <= high && nums[i] < pivotKey) ++i;
            while (j >= low && nums[j] > pivotKey) --j;
            if (i >= j) break;
            swap(nums, i++, j--);
        }
        swap(nums, low, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partitionOneWay(int[] nums, int low, int high) {
        int pivotKey = nums[low];
        int swapPos = low + 1;
        for (int i = low + 1; i <= high; ++i) {
            if (nums[i] < pivotKey) {
                swap(nums, i, swapPos++);
            }
        }
        swap(nums, low, swapPos - 1);
        return swapPos - 1;
    }

    public int partitionOneWay2(int[] nums, int low, int high) {
        int pivotKey = nums[low];
        int j = low; // largest index of the area < pivotKey
        for (int i = low + 1; i <= high; ++i) { // the next index to be sorted
            if (nums[i] < pivotKey) {
                swap(nums, i, ++j);
            }
        }
        swap(nums, low, j);
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {6, 6, 5, 4, 3, 2, 1, 0, -1};
        new QuickSort().sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
