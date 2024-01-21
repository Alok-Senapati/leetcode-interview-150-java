package org.practice.leetcode.array_string;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int leftMostReachable = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (leftMostReachable - i <= nums[i]) {
                leftMostReachable = i;
            }
        }
        return leftMostReachable == 0;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
