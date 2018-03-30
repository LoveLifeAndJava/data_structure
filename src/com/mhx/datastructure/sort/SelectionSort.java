package com.mhx.datastructure.sort;

import java.util.Arrays;

/**
 * @author MHX
 * @date 2018/3/29
 */
public class SelectionSort {
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            // find minIndex in [i, nums.length)
            int minIndex = i;
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 8, 5, 7, 4};
        new SelectionSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
