package com.uaian.algorithms.leecode;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(curSum < 0){
                curSum = nums[i];
            }else {
                curSum += nums[i];
            }
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
