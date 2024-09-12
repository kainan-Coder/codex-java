package com.uaian.algorithms.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            list.add(deque.peekLast().val);
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if(poll.left != null)
                    deque.addLast(poll.left);
                if(poll.right != null)
                    deque.addLast(poll.right);
            }
        }
        return list;
    }
}
