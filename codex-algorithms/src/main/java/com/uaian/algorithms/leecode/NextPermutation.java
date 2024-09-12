package com.uaian.algorithms.leecode;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >= 0){
            int j = n - 1;
            while (j >= 0 && nums[i] >= nums[j]){
                j--;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

}
