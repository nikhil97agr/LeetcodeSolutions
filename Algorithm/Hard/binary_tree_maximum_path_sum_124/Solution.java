package binary_tree_maximum_path_sum_124;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public int maxPathSum(TreeNode root) {
        TreeNode result = new TreeNode(Integer.MIN_VALUE);

        solve(root, result);
        return result.val;
    }

    private int solve(TreeNode root, TreeNode result){
        if(root==null){
            return 0;
        }

        int left = solve(root.left, result);
        int right = solve(root.right, result);

        result.val = Math.max(result.val, Math.max(root.val, Math.max(root.val + left + right, Math.max(left, right)+root.val)));

        return Math.max(Math.max(left, right)+root.val, root.val);

    }
}