package com.uaian.algorithms.tree;

public class BinaryTreeMaximumPathSum {

    Integer maxLen = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        recursion(root);
        return maxLen;
    }

    private int recursion(TreeNode root) {
        if(root == null)
            return 0;

        int left = Math.max(maxPathSum(root.left), 0);
        int right = Math.max(maxPathSum(root.right), 0);

        maxLen = Math.max(maxLen, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
