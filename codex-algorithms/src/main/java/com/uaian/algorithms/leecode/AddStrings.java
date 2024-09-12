package com.uaian.algorithms.leecode;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1, index2 = num2.length() -1;
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        while (index1 >= 0 && index2 >= 0){
            int c1 = num1.charAt(index1) - '0';
            int c2 = num1.charAt(index2) - '0';
            int cur = (c1 + c2 + flag) % 10;
            flag = (c1 + c2+ flag) / 10;
            sb.append(cur);
            index1--;
            index2--;

        }
        while (index1 >= 0){
            int c1 = num1.charAt(index1) - '0';
            int cur = (c1 + flag) % 10;
            flag = (c1 + flag) / 10;
            sb.append(cur);
            index1--;
        }
        while (index2 >= 0){
            int c2 = num1.charAt(index2) - '0';
            int cur = (c2 + flag) % 10;
            flag = (c2+ flag) / 10;
            sb.append(cur);
            index2--;
        }
        if(flag > 0)
            sb.append(flag);
        return sb.reverse().toString();
    }
}
