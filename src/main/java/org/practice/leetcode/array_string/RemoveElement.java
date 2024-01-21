package org.practice.leetcode.array_string;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] == val) {
                nums[start] = nums[end--];
            } else {
                start++;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 6, 4, 3, 2, 4, 9, 6, 4};
        int end = new RemoveElement().removeElement(arr, 4);
        for (int i = 0; i < end; i++) {
            System.out.println(arr[i]);
        }
    }
}
