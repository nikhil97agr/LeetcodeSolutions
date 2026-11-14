/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>();
        for(TreeNode node : nodes) set.add(node);

        return solve(root, set);
    }

    private TreeNode solve(TreeNode root, Set<TreeNode> set){
        if(root == null) return null;

        TreeNode left = solve(root.left, set);
        TreeNode right = solve(root.right, set);

        if(set.contains(root)){
            return root;
        }

        if(left == null && right == null) return null;
        if(left == null) return right;
        if(right == null) return left;

        return root;
    }
}