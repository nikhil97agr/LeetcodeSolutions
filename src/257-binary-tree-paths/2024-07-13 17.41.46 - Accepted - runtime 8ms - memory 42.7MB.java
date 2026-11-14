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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        solve(result, root, "");
        return result;
    }

    private void solve(List<String> result , TreeNode root, String curr){
        if(root == null) return;

        if(root.left == null && root.right == null){
            result.add(curr+root.val);
            return;
        }

        solve(result, root.left, curr+root.val+"->");
        solve(result, root.right, curr+root.val+"->");
    }
}