package equal_tree_partition_663;

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
    public boolean checkEqualTree(TreeNode root) {
        dfs(root);

        return dfs(root, 0);
    }

    private boolean dfs(TreeNode root, int upper){
        if(root ==null) return false;
        if(root.left != null){
            int s1 = root.val - root.left.val + upper;
            int s2 = root.left.val;

            if(s1 == s2) return true;
            if(dfs(root.left, s1)) return true;

        }

        if(root.right != null){
            int s1 = root.val - root.right.val + upper;
            int s2 = root.right.val;

            if(s1 == s2){
                return true;
            }

            if(dfs(root.right, s1)) return true;
        }


        return false;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        root.val += left + right;

        return root.val;
    }
}