package org.practice.leetcode.array_string;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int insert_idx = m + n - 1;
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[insert_idx--] = nums1[p1--];
            } else {
                nums1[insert_idx--] = nums2[p2--];
            }
        }
        while(p2 >= 0){
            nums1[insert_idx--] = nums2[p2--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1, 2, 3};
        new MergeSortedArray().merge(nums1, 3, nums2, 3);
        for(int x: nums1){
            System.out.print("" + x + " ");
        }
    }
}
