package binary_tree_inorder_traversal_94;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        tra(root, result);
        return result;
    }

    private void tra(TreeNode root, List<Integer> result){
        if(root==null){
            return ;
        }

        tra(root.left, result);
        result.add(root.val);
        tra(root.right, result);
    }
}