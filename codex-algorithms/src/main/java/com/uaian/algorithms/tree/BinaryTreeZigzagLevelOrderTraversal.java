package com.uaian.algorithms.tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null)
            return lists;
        boolean isLeft = false;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.pollFirst();
                if(isLeft){
                    list.addFirst(poll.val);
                }else {
                    list.addLast(poll.val);
                }
                if(poll.left != null)
                    deque.addLast(poll.left);
                if(poll.right != null)
                    deque.addLast(poll.right);
            }
            lists.add(list);
            isLeft = !isLeft;
        }
        return lists;
    }
}
