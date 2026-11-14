package house_robber_iii_337;

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
    public int rob(TreeNode root) {
        int ans[] = solve(root);

        return Math.max(ans[0], ans[1]);


    }

    private int[] solve(TreeNode root){
        if(root==null) return new int[]{0,0};

        int left[] = solve(root.left);

        int right[] = solve(root.right);

        int with = root.val + left[0] + right[0];
        int without = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{without, with};
    }
}