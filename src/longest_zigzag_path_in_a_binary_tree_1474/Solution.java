package longest_zigzag_path_in_a_binary_tree_1474;

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
    public int longestZigZag(TreeNode root) {
            solve(root.right, 0, true);
            solve(root.left, 0, false);
                return ans;
    }

    private void solve(TreeNode root, int count, boolean isLeft){
        if(root==null){
            ans = Math.max(ans, count);
            return;
        }

        if(isLeft){
            solve(root.left, count+1, false);
            solve(root.right, 0, true);
        }
        else{
            solve(root.right, count+1, true);
            solve(root.left , 0, false);
        }


    }


}