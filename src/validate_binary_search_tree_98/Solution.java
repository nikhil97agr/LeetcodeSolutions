package validate_binary_search_tree_98;

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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;

        return traverse(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    private boolean traverse(Long lower, Long upper, TreeNode root){
        if(root==null) return true;

        if(root.val<=lower || root.val >= upper){
            return false;
        }

        return traverse(lower, (long)root.val, root.left) && traverse((long)root.val, upper, root.right);
    }
}