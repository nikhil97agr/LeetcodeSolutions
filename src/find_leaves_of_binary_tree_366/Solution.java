package find_leaves_of_binary_tree_366;

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        height(root, result);
        return result;
    }

    private int height(TreeNode root, List<List<Integer>> result){
        if(root==null) return -1;
        
        int l = height(root.left, result);
        int r = height(root.right, result);

        int h = Math.max(l, r)+1;
        if(result.size()<=h){
            result.add(new ArrayList<>());
        }

        result.get(h).add(root.val);
        return h;
    }
}