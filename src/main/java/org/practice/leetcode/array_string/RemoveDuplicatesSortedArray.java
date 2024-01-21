package org.practice.leetcode.array_string;

public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        int start = 1;
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] || counter < 2) {
                counter = nums[i] != nums[i - 1] ? 1 : counter + 1;
                nums[start++] = nums[i];
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int n = new RemoveDuplicatesSortedArray().removeDuplicates(nums);
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }
}
