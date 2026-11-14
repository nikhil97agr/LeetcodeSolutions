package count_dominant_nodes_in_a_binary_tree_4358;

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
    public int countDominantNodes(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if(root == null){
            return -1;
        }


        int max = Math.max(dfs(root.left), dfs(root.right));
        max = Math.max(max, root.val);
        if(max == root.val){
            ans++;
        }

        return Math.max(max, root.val);
    }
}