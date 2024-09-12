package com.uaian.algorithms.leecode;

public class StringToIntegerAtoi {
    public int myAtoi(String s) {
        int n = s.length();
        int index = 0;
        while (index < n && s.charAt(index) == ' '){
            index++;
        }
        if(index >= n)
            return 0;
        int flag = 1;
        if(s.charAt(index) == '-'){
            index++;
            flag = -1;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        while (index < s.length() && s.charAt(index) == '0'){
            index++;
        }
        int ans = 0;

        while (index < n){
            char c = s.charAt(index);
            if(c < '0' || c > '9')
                return ans;
            int num = c - '0';
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10))
                return Integer.MAX_VALUE;
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && num > -(Integer.MIN_VALUE % 10)))
                return Integer.MIN_VALUE;
            ans = ans * 10 + num * flag;
            index++;
        }

        return ans ;


    }
}
