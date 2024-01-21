package org.practice.leetcode.array_string;

public class RemoveDuplicatesSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int start = 1;
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] && counter > 2) {
                nums[start++] = nums[i];
                counter = 1;
            } else {
                counter++;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int n = new RemoveDuplicatesSortedArray().removeDuplicates(nums);
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }
}
