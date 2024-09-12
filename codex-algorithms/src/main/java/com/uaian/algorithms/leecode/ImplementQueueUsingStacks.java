package com.uaian.algorithms.leecode;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> stack1 = null;
    Stack<Integer> stack2 = null;

    public ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack2.push(x);
    }

    public int pop() {
        if(stack1.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        return stack1.pop();
    }

    public int peek() {
        if(stack1.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
