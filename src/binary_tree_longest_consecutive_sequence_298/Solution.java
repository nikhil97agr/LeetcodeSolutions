package binary_tree_longest_consecutive_sequence_298;

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
    public int longestConsecutive(TreeNode root) {
        solve(root, root.val, 1);
        return ans;
    }

    private void solve(TreeNode root, int prev, int cnt){
        if(root == null){
            ans = Math.max(ans, cnt);
            return;
        }

        if(root.val == prev + 1){
            cnt++;
        }else{
            ans = Math.max(cnt, ans);
            cnt = 1;
        }

        solve(root.left, root.val, cnt);
        solve(root.right, root.val, cnt);
    }
}