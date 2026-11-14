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
    public int equalToDescendants(TreeNode root) {
        return dfs(root).cnt;
    }

    public Result dfs(TreeNode root){
        if(root == null) return new Result(0, 0);

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        int sum = left.sum + right.sum;
        int total = left.cnt + right.cnt;
        if(sum == root.val) total++;

        return new Result(sum + root.val, total);
    }

    class Result{
        int sum;
        int cnt;

        public Result(int sum, int cnt){
            this.cnt = cnt;
            this.sum = sum;
        }
    }
}