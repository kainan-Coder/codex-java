package com.uaian.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    private void recursion(TreeNode root, List<Integer> list) {
        if(root == null)
            return;

        recursion(root.left, list);
        list.add(root.val);
        recursion(root.right, list);
    }
}
