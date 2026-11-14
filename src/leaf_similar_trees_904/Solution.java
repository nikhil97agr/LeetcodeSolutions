package leaf_similar_trees_904;

import java.util.*;
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        traverse(root1, l1);
        traverse(root2, l2);
        return l1.equals(l2);
    }

    private void traverse(TreeNode root, List<Integer> list){
        if(root==null) return;

        if(root.left==null && root.right==null){
            list.add(root.val);
            return;
        }

        traverse(root.left, list);
        traverse(root.right, list);
    }
}