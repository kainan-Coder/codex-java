package com.uaian.algorithms.leecode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        while (true){
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            if(++top > bottom){
                break;
            }
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            if(--right < left){
                break;
            }
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            if(--bottom < top){
                break;
            }
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            if(++left > right){
                break;
            }
        }
        return ans;
    }

}
