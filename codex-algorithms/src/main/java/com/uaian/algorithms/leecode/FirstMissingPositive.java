package com.uaian.algorithms.leecode;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] <= 0 || nums[i] >= n + 1)
                nums[i] = n + 1;
        }
        for (int i = 0; i < n; i++) {
            int tmp = Math.abs(nums[i]);
            if(tmp < n + 1)
                nums[tmp - 1] = - Math.abs(nums[tmp - 1]);
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }
}
