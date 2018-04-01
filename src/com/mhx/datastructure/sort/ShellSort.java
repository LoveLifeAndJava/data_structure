package com.mhx.datastructure.sort;

import java.util.Arrays;

/**
 * @author MHX
 * @date 2018/3/30
 */
public class ShellSort {
    /**
     * using Knuth's sequence
     * @param nums
     */
    public void sortKnuthsSeq(int[] nums) {
        int step = 1;
        // use Knuth's sequence a(n) = (3^n - 1) /  2
        // we can obtain a(n) = 3 * a(n-1) + 1
        while (3 * step + 1 <= nums.length) {
            step = 3 * step + 1;
        }
        while (step != 0) {
            System.out.print(step + ",");
            for (int i = step; i < nums.length; ++i) {
                int temp = nums[i];
                int j;
                for (j = i; j - step >= 0 && nums[j - step] > temp; j -= step) {
                    nums[j] = nums[j - step];
                }
                nums[j] = temp;
            }
            // no need to plus 1
            step = step / 3;
        }
    }

    /**
     * using normal sequence
     * @param nums
     */
    public void sort(int[] nums) {
        int step = nums.length;
        do {
            step = step / 3 + 1;
            System.out.print(step + ",");
            for (int i = step; i < nums.length; ++i) {
                int temp = nums[i];
                int j;
                for (j = i; j - step >= 0 && nums[j - step] > temp; j -= step) {
                    nums[j] = nums[j - step];
                }
                nums[j] = temp;
            }
        } while (step != 1);
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 4, 3, 2, 1, 0, -1, 6, 5, 4, 3, 2, 1, 0, -1, 6, 5, 4, 3, 2, 1, 0, -1, 6, 5, 4, 3, 2, 1, 0, -1, 0, -1, 6, 5, 4, 3, 2, 1, 0, -1, 0, -1, 6, 5, 4, 3, 2, 1, 0, -1};
        new ShellSort().sort(nums);
        System.out.println();
        System.out.println(Arrays.toString(nums));
    }
}
