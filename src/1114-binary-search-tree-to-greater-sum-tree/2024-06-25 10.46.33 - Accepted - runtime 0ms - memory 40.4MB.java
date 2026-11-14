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
    public TreeNode bstToGst(TreeNode root) {
        solve(root, 0);
        return root;
    }
    
    public int solve(TreeNode root, int sum)
    {
        if(root==null)
            return sum;
        
        root.val = root.val + solve(root.right, sum);
        sum = solve(root.left, root.val);
        return sum;
    }
}