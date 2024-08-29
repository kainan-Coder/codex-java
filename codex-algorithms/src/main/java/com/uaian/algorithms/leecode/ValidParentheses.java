package com.uaian.algorithms.leecode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '}' && (stack.isEmpty() || stack.pop() != '{')){
                return false;
            } else if (s.charAt(i) == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            } else if (s.charAt(i) == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            }else if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
