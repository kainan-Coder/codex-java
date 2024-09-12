package com.uaian.algorithms.dp;

public class TrappingRainWater {
    public int trap(int[] height) {
        int len = height.length;
        int sum = 0;
        int[] left = new int[len];
        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        int[] right = new int[len];
        right[len-1] = height[len-1];
        for (int i = len-2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }

        for (int i = 0; i < len; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }
}
