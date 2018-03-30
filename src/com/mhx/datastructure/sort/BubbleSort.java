package com.mhx.datastructure.sort;

import java.util.Arrays;

/**
 * @author MHX
 * @date 2018/3/30
 */
public class BubbleSort {
    /**
     * max to the top
     * @param nums
     */
    public void sortMax(int[] nums) {
        for (int i = nums.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    /**
     * min to the top
     * @param nums
     */
    public void sortMin(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; --j) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }

    /**
     * min to the top, optimize swap times
     * @param nums
     */
    public void sortMinOptimize(int[] nums) {
        boolean swapFlag = true;
        for (int i = 0; i < nums.length && swapFlag; i++) {
            swapFlag = false;
            for (int j = nums.length - 1; j > i; --j) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                    swapFlag = true;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 4, 3, 2, 1, 0, -1};
        new BubbleSort().sortMinOptimize(nums);
        System.out.println(Arrays.toString(nums));
    }

}
