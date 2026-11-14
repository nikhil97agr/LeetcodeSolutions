package path_sum_112;

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum, 0);
    }
    
    public boolean solve(TreeNode root, int target, int sum){
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return target == sum + root.val;
        }
        return solve(root.left, target, sum + root.val)||solve(root.right, target, sum + root.val);
    }
}