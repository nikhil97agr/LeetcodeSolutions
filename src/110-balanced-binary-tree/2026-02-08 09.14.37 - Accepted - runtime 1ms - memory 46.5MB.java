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
    public boolean isBalanced(TreeNode root) {
        return solve(root).res;
    }

    private Pair solve(TreeNode root){
        if(root == null){
            return new Pair(0, true);
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);
        if(!left.res || !right.res){
            return new Pair(0, false);
        }
        Pair res = new Pair(Math.max(left.height, right.height)+1, true);
        if(Math.abs(right.height - left.height) > 1){
            res.res = false;
        }

        return res;
    }

    class Pair{
        int height;
        boolean res;

        public Pair(int height, boolean res){
            this.height = height;
            this.res = res;
        }
    }
}