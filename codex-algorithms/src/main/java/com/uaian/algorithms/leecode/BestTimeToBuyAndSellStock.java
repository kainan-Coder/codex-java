package com.uaian.algorithms.leecode;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = prices[0];
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        return max;
    }
}
