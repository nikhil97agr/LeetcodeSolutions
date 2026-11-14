package lowest_common_ancestor_of_deepest_leaves_1218;

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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return solve(root).root;
    }

    private Pair solve(TreeNode root){

        if(root ==null){
            return new Pair(root, 0);
        }

        Pair left = solve(root.left);
        Pair right =solve(root.right);

        if(left.d > right.d){
            return new Pair(left.root, left.d+1);
        }
        if(left.d < right.d){
            return new Pair(right.root, right.d+1);
        }

        return new Pair(root, right.d+1);
    }

    private class Pair{
        TreeNode root;
        int d;
        public Pair(TreeNode root, int d){
            this.d = d;
            this.root = root;
        }
    }
}
