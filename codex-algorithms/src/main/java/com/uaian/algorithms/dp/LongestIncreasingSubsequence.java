package com.uaian.algorithms.dp;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int j = i - 1;
            int tmp = nums[i];
            dp[i] = 1;
            while (j >= 0){
                dp[i] = tmp > nums[j] ? Math.max(dp[i], dp[j] + 1) : dp[i];
                max = Math.max(dp[i], max);
                j--;
            }
        }
        return max;
    }
}
