package path_sum_iii_437;

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
    public int pathSum(TreeNode root, int target) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0l,1);
        return solve(root, 0l, prefix, target);
    }

    private int solve(TreeNode root, long curr, Map<Long, Integer> prefix, int target){
        if(root==null) return 0;

        curr += root.val;

        int total = prefix.getOrDefault(curr-target, 0);    
        prefix.put(curr, prefix.getOrDefault(curr, 0)+1);

        total += solve(root.left, curr, prefix, target ) + solve(root.right, curr, prefix, target);
        prefix.put(curr, prefix.get(curr)-1);
        return total;
    }
}