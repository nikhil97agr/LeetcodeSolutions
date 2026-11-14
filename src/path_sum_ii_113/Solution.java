package path_sum_ii_113;

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        solve(root, targetSum, result, temp,0);
        return result;
    }
    
    public void solve(TreeNode root, int target, List<List<Integer>> result, List<Integer> temp,int sum){
        if(root==null){
            return;
        }
        
        if(root.left==null&&root.right==null){
            sum += root.val;
            temp.add(root.val);
            if(target==sum){
                result.add(new ArrayList<Integer>(temp));
            }
            temp.remove(temp.size()-1);
            return;
        }
        temp.add(root.val);

        
        solve(root.left, target, result, temp, sum + root.val);
        solve(root.right, target, result, temp, sum + root.val);
        temp.remove(temp.size()-1);
        
        return;
    }
}