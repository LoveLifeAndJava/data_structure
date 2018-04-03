package com.mhx.datastructure.sort;

import java.util.Arrays;

/**
 * @author MHX
 * @date 2018/4/3
 */
public class HeapSort {
    public void sort(int[] nums, int n, int k) {
        // heapify (build the array into a max heap)
        for (int i = (n - 1) / 2; i >= 0; --i) {
            shiftDown(nums, n, i);
        }
        // i > 0, when the array contains only one element, do nothing.
        for (int i = n - 1; i > 0; --i) {
            swap(nums, 0, i);
            shiftDown(nums, i, 0);
        }
    }

    private void shiftDown(int[] nums, int n, int k) {
        while (k * 2 + 1 < n) {
            int j = k * 2 + 1;
            if (j + 1 < n && nums[j + 1] > nums[j]) {
                j += 1;
            }
            if (nums[k] >= nums[j]) {
                break;
            }
            swap(nums, k, j);
            k = j;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 4, 3, 2, 1, 0, -1, 6, 5, 4, 3, 6, 5, 4, 3, 6, 5, 4, 3};
        new HeapSort().sort(nums, nums.length, 0);
        System.out.println(Arrays.toString(nums));
    }
}
