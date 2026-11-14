package minimum_distance_between_bst_nodes_799;

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
  TreeNode previous = null;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return min;
    }
    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(previous!=null){
            min = Math.min(min, root.val-previous.val);
        }
        previous = root;
        inOrder(root.right);
    }
}