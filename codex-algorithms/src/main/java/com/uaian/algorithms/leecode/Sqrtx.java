package com.uaian.algorithms.leecode;

public class Sqrtx {
    public int mySqrt(int x) {
        int ans = 0;
        int start = 0, end = x;
        while (start <= end){
            int mid = (start + end)/2;
            if((long)mid * mid <= x){
                ans = mid;
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
