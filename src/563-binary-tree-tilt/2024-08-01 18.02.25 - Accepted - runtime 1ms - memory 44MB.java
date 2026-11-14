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
    public int findTilt(TreeNode root) {
        return solve(root)[1];
    }


    private int[] solve(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }

        int left[] = solve(root.left);
        int right[] = solve(root.right);

        return new int[]{left[0] + right[0] + root.val, left[1] + right[1] + Math.abs(left[0] - right[0])};
    }
}