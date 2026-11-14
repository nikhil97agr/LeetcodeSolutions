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

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int height = height(root);
        return dfs(root, height, 1);
    }

    private TreeNode dfs(TreeNode root, int maxHeight, int currDepth){
        if(root==null) return root;
        if(currDepth == maxHeight) return root;

        TreeNode left = dfs(root.left, maxHeight, currDepth + 1);
        TreeNode right = dfs(root.right, maxHeight, currDepth + 1);
        if(left == null && right==null) return null;
        if(left == null) return right;
        if(right == null) return left;

        return root;
    }

    private int height(TreeNode root){
        if(root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}