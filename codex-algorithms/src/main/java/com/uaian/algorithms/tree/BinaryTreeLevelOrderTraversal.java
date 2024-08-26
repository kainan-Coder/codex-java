package com.uaian.algorithms.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null)
            return lists;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode po = deque.pollFirst();
                list.add(po.val);
                if(po.left != null){
                    deque.addLast(po.left);
                }
                if(po.right != null){
                    deque.addLast(po.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
