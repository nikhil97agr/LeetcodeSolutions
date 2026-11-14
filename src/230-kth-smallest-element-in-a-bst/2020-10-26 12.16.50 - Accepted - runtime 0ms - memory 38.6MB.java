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
    int ans = -1;
    public int kthSmallest(TreeNode root, int k) {
        solve(root, 0,k);
        return ans;
    }
    
    public int solve(TreeNode root, int count, int k)
    {
        if(root==null)
        {
            return count;
        }
        if(ans!=-1)
        {
            return count;
        }
        if(count==k)
        {
            return count;
        }
        count = solve(root.left, count, k);
        count++;
        if(count==k)
        {
            ans = root.val;
            return count;
        }
        count = solve(root.right, count,k);
        return count;
    }
}