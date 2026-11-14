package height_of_special_binary_tree_2944;

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
    public int heightOfTree(TreeNode root) {
        if(root == null || (root.left != null && root.left.right == root)) return 0;


        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) +1;
    }
}