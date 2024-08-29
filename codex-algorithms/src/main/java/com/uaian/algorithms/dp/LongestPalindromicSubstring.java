package com.uaian.algorithms.dp;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2)
            return s;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int maxLen = 0;
        for (int l = 2; l < len; l++) {
            for (int left = 0; left < len; left++) {
                int right = left + len - 1;
                if(right >= len)
                    break;
                if(s.charAt(left) != s.charAt(right)){
                    dp[left][right] = false;
                }else {
                    if(l <= 3){
                        dp[left][right] = true;
                    }else {
                        dp[left][right] = dp[left+1][right-1];
                    }
                }
                if(dp[left][right] && l > maxLen){
                    start = left;
                    maxLen = l;
                }

            }
        }

        return s.substring(start, start + maxLen);

    }
}
