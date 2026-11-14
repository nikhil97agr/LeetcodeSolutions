package add_one_row_to_tree_623;

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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return solve(root, val, 1, depth, true);
    }
    
    public TreeNode solve(TreeNode root, int val, int curr, int depth, boolean isLeft){
        if(curr == depth){
            TreeNode node = new TreeNode(val);
            if(!isLeft){
                node.right = root;
            }else{
                node.left = root;
            }
            return node;
        }
        if(root==null){
            return null;
        }
        
        root.left = solve(root.left, val, curr+1, depth, true);
        root.right = solve(root.right, val, curr+1, depth, false);
        return root;
    }
}