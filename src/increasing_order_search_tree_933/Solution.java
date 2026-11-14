package increasing_order_search_tree_933;

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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inorder(root, list);
        TreeNode node = new TreeNode(-1);
        TreeNode curr= node;
        for(int x : list){
            curr.right = new TreeNode(x);
            curr = curr.right;
        }

        return node.right;
    }

    private void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}