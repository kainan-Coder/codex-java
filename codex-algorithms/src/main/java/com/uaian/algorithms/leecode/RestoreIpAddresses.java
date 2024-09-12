package com.uaian.algorithms.leecode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    List<String> list = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if(n < 4 || n > 12)
            return list;
        backTrace(s, 0, 0);
        return list;
    }

    private void backTrace(String s, int start, int count) {
        if(count == 3){
            if(isVaild(s, start, s.length() - 1)){
                list.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if(isVaild(s, start, i)){
                s = s.substring(start, i) + "." + s.substring(i + 1);
                count++;
                backTrace(s, i, count);
                count--;
                s = s.substring(start,i) + s.substring(i + 2);
            }else {
                break;
            }
        }
    }

    private boolean isVaild(String s, int start, int end) {
        if(start > end)
            return false;
        if(start != end && s.startsWith("0"))
            return false;

        int ans = 0;
        while (start <= end){
            char c = s.charAt(start);
            if(c < '0' || c > '9')
                return false;
            int num = c - '0';
            ans += ans * 10 + num;
            start++;
        }

        if(ans > 255)
            return false;


        return true;
    }
}
