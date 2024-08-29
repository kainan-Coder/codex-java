package com.uaian.algorithms.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        findAllC2P(root, map);
        ArrayList<TreeNode> list = new ArrayList<>();
        while (p != null){
            list.add(p);
            p = map.get(p);
        }
        while (q != null){
            if(list.contains(q)){
                return q;
            }
            q = map.get(q);
        }
        return null;
    }

    private void findAllC2P(TreeNode root, Map<TreeNode, TreeNode> map) {
        if(root.left != null){
            map.put(root.left, root);
            findAllC2P(root.left, map);
        }

        if(root.right != null){
            map.put(root.right, root);
            findAllC2P(root.right, map);
        }
    }
}
