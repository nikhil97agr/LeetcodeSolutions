/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return solve(root, 0);
    }

    private int solve(TreeNode root, int val){
        if(root == null) return 0;
        int newVal = (val << 1) | root.val;

        int left = 0;
        int right = 0;

        if(root.left == null && root.right == null){
            return newVal;
        }

        if(root.left != null){
            left = solve(root.left, newVal);
        }

        if(root.right!=null){
            right = solve(root.right, newVal);
        }

        return left + right;
    }
    
}