package split_bst_791;

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
    public TreeNode[] splitBST(TreeNode root, int target) {

        return solve(root, target);
    }

    private TreeNode[] solve(TreeNode root, int target){
        if(root==null) return new TreeNode[]{null, null};

        if(root.val > target){
            TreeNode result[] = solve(root.left, target);
            root.left = result[1];
            result[1] = root;
            return result;
        }

        TreeNode result[] = solve(root.right, target);
        root.right = result[0];
        result[0] = root;
        return result;
    }
}