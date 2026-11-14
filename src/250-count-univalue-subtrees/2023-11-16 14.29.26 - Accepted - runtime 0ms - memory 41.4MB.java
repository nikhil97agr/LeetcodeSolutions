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
    public int countUnivalSubtrees(TreeNode root) {
        int ans[] = new int[]{0};
        solve(root, ans);
        return ans[0];
    }

    private int[] solve(TreeNode root, int ans[]){
        if(root==null) return new int[]{-1001, -1001};

        int left[] = solve(root.left, ans);
        int right[] =solve(root.right, ans);

        int curr[] = new int[]{root.val, root.val};
        if(left[0]!=-1001){
            curr =new int[] {Math.max(curr[0], left[0]), Math.min(curr[1], left[1])};
        }

        if(right[0]!=-1001){
            curr = new int[]{Math.max(curr[0], right[0]), Math.min(curr[1], right[1])};
        }

        if(curr[0]==curr[1]) ans[0]++;
        return curr;
    }
}