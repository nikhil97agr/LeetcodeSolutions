package binary_tree_pruning_832;

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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;

        if(root.left == null && root.right == null){
            if(root.val == 1) return root;
            return null;
        }

        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        root.left = left;
        root.right = right;
        if(left == null && right == null){
            if(root.val == 1) return root;
            return null;
        }

        return root;
    }
}