package com.mhx.datastructure.sort;

import java.util.Arrays;

/**
 * @author MHX
 * @date 2018/3/30
 */
public class InsertionSort {
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            for (int j = i; j - 1 >= 0; --j) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }

    public void sortOptimized(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            int temp = nums[i];
            int j;
            for (j = i; j - 1 >= 0 && nums[j - 1] > temp; --j) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 6, 8, 5, 7, 4};
        new InsertionSort().sortOptimized(nums);
        System.out.println(Arrays.toString(nums));
    }
}
