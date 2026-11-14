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
    public int findDistance(TreeNode root, int p, int q) {
        if(p==q) return 0;
        TreeNode ancestor = ancestor(root, p, q);

        int c1 = cnt(ancestor, p, 0);
        int c2 = cnt(ancestor, q, 0);
        return c1 + c2;
    }

    private int cnt(TreeNode root, int val, int depth){
        if(root==null) return 0;

        if(root.val == val) return depth;

        return Math.max(cnt(root.left, val, depth + 1), cnt(root.right, val, depth + 1));
    }

    private TreeNode ancestor(TreeNode root, int p, int q){
        if(root==null) return null;

        TreeNode left = ancestor(root.left, p, q);
        TreeNode right = ancestor(root.right, p, q);
        if(left !=null && right!=null){
            return root;
        }
        if(root.val == p || root.val == q) return root;

        if(left !=null) return left;
        return right;
    }
}