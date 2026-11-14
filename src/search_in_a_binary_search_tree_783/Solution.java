package search_in_a_binary_search_tree_783;

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
    public TreeNode searchBST(TreeNode root, int val) {
            if(root==null){
                return null;

            }

            if(root.val==val){
                return root;
            }

            TreeNode left = searchBST(root.left, val);
            if(left==null){
                return searchBST(root.right, val);
            }
            return left;
    }
}