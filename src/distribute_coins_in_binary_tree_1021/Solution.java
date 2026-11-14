package distribute_coins_in_binary_tree_1021;

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
    public int distributeCoins(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        
        int leftCount = count(root.left), rightCount = count(root.right);
        int leftCoin = coin(root.left), rightCoin = coin(root.right);
        
        int moves = Math.abs(leftCount-leftCoin) + Math.abs(rightCount - rightCoin);
        
        return moves + distributeCoins(root.left)+distributeCoins(root.right);
    }
    
    int coin(TreeNode root)
    {
        if(root==null)
            return 0;
        return root.val + coin(root.right) + coin(root.left);
    }
    
    int count(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1 + count(root.right) + count(root.left);
    }
}