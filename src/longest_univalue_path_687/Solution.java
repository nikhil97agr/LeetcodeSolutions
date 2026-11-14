package longest_univalue_path_687;

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
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        solve(root, root.val);
        return ans-1;
    }

    private int solve(TreeNode root, int val){
        if(root == null) return 0;

        int left = solve(root.left, root.val);
        int right = solve(root.right, root.val);


        ans = Math.max(ans, left + right + 1);

        if(root.val != val) return 0;

        return Math.max(left, right) + 1;
    }
}