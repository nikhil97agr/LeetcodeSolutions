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
    public int sumEvenGrandparent(TreeNode root) {
        return solve(root, null, null);
    
    }
    public int solve(TreeNode root, TreeNode parent, TreeNode grandParent){
        if(root==null){
            return 0;
        }
        if(grandParent!=null){
            if(grandParent.val%2==0){
                return root.val + solve(root.left, root, parent) + solve(root.right, root, parent);
            }
        }
        return solve(root.left, root, parent) + solve(root.right, root, parent);
    }
}