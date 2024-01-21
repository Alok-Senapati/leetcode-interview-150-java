package org.practice.leetcode.two_pointer;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            left = sum < target ? left + 1 : left;
            right = sum > target ? right - 1 : right;
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int[] input1 = {2, 7, 11, 15};
        int[] result1 = new TwoSumII().twoSum(input1, 9);
        int[] input2 = {2, 3, 4};
        int[] result2 = new TwoSumII().twoSum(input2, 6);
        int[] input3 = {-1, 0};
        int[] result3 = new TwoSumII().twoSum(input3, -1);
        System.out.println("" + input1[result1[0] - 1] + " + " + input1[result1[1] - 1] + " = 9");
        System.out.println("" + input2[result2[0] - 1] + " + " + input2[result2[1] - 1] + " = 6");
        System.out.println("" + input3[result3[0] - 1] + " + " + input3[result3[1] - 1] + " = -1");
    }
}
