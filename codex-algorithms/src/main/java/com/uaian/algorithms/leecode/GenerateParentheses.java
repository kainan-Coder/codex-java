package com.uaian.algorithms.leecode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrace(0, 0, n, list, new StringBuilder());
        return list;
    }

    private void backTrace(int left, int right, int n, List<String> list, StringBuilder sb) {
        if(sb.length() == 2 * n){
            list.add(sb.toString());
            return;
        }

        if(left < n){
            sb.append("(");
            backTrace(left+1, right, n, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(right < left){
            sb.append(")");
            backTrace(left, right+1, n, list, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
