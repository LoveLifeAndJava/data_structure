package com.mhx.datastructure.sort;

import java.util.Arrays;

/**
 * @author MHX
 * @date 2018/4/1
 */
public class MergeSort {

    /**
     * Top-down recursive implementation
     * sort range is [low, high)
     *
     * @param nums
     * @param low  inclusive
     * @param high exclusive
     */
    public void mergeSortTopDown(int[] nums, int low, int high) {
        // need extra O(n) auxiliary space
        int[] aux = new int[nums.length];
        sortOptimzed(nums, aux, low, high);
    }

    /**
     * normal implementation
     *
     * @param nums
     * @param aux
     * @param low
     * @param high
     */
    public void sort(int[] nums, int[] aux, int low, int high) {
        if (low < high - 1) {
            int mid = low + high >>> 1;
            sort(nums, aux, low, mid);
            sort(nums, aux, mid, high);
            merge(nums, aux, low, mid, high);
        }
    }

    /**
     * optimized implementation
     *
     * @param nums
     * @param aux
     * @param low
     * @param high
     */
    public void sortOptimzed(int[] nums, int[] aux, int low, int high) {
        // when high - low < a small number, we can use insertion sort to increase speed
        // because when the number is very small, we can consider the array to be nearly sorted
        // ...

        if (low < high - 1) {
            int mid = low + high >>> 1;
            sortOptimzed(nums, aux, low, mid);
            sortOptimzed(nums, aux, mid, high);
            if (nums[mid] > nums[mid + 1]) {
                // only need to merge it when it is unsorted
                merge(nums, aux, low, mid, high);
            }
        }
    }

    /**
     * merge two sorted arrays: [low, mid), [mid, high)
     * i, j on aux
     * k on nums
     */
    public void merge(int[] nums, int[] aux, int low, int mid, int high) {
        int i = low;
        int j = mid;
        int k = low;

        // the auxiliary array will be changed every time
        for (; k < high; ++k) {
            aux[k] = nums[k];
        }

        k = low;

        while (k < high) {
            if (i > mid - 1) {
                nums[k++] = aux[j++];
            } else if (j > high - 1) {
                nums[k++] = aux[i++];
            } else if (aux[i] < aux[j]) {
                nums[k++] = aux[i++];
            } else {
                nums[k++] = aux[j++];
            }
        }
    }

    /**
     * Bottom-up iterative implementation
     *
     * @param nums
     */
    public void mergeSortBottomUp(int[] nums) {
        int[] aux = new int[nums.length];
        for (int size = 1; size < nums.length; size *= 2) {
            for (int low = 0; low < nums.length - size; low += size * 2) {
                merge(nums, aux, low, low + size, Math.min(low + 2 * size, nums.length));
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 4, 3, 2, 1, 0, -1, 6, 5, 4, 3, 6, 5, 4, 3, 6, 5, 4, 3};
//        new MergeSort().mergeSortTopDown(nums, 0, nums.length);
        new MergeSort().mergeSortBottomUp(nums);
        System.out.println(Arrays.toString(nums));
    }
}
