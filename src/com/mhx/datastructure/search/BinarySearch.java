package com.mhx.datastructure.search;

/**
 * @author MHX
 * @date 2018/4/4
 */
public class BinarySearch {
    int binarySearch(int nums[], int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + high >>> 1;
            if (target < nums[mid]) {
                high = mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    int binarySearchRecursive(int nums[], int target, int low, int high) {
        if (low >= high) {
            return -1;
        }
        int mid = low + high >>> 1;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearchRecursive(nums, target, mid + 1, high);
        } else {
            return binarySearchRecursive(nums, target, low, mid);
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 4, 5, 6, 7, 9, 8};
        System.out.println(new BinarySearch().binarySearch(nums, 1));
        System.out.println(new BinarySearch().binarySearchRecursive(nums, 1, 0, nums.length));
    }
}
