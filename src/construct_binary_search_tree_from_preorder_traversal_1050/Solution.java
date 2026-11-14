package construct_binary_search_tree_from_preorder_traversal_1050;

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
    int ind = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        

        return solve(preorder,  Integer.MAX_VALUE);


    }

    private TreeNode solve(int preorder[], int upper){
        if(ind == preorder.length || preorder[ind] > upper){
            return null;
        }

        TreeNode node = new TreeNode(preorder[ind++]);

        node.left = solve(preorder,  node.val);
        node.right = solve(preorder,  upper);
        return node;
    }
}