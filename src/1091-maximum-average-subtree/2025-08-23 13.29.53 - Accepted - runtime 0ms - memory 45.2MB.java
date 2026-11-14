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
    double ans = 0d;
    public double maximumAverageSubtree(TreeNode root) {
        solve(root);
        return ans;
    }

    private int [] solve(TreeNode root){
        if(root == null) return new int[]{0, 0};

        int left[] = solve(root.left);
        int right[] = solve(root.right);

        int total = root.val + left[0] + right[0];

        int cnt = left[1] + right[1] + 1;

        double avg = (1d*total)/cnt;


        ans = Math.max(ans, avg);

        return new int[]{total, cnt}; 


    }
}