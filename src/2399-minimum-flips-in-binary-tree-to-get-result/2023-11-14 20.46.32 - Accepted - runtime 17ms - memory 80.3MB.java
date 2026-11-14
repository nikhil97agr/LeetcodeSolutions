/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    enum Operations{
        FALSE, TRUE, OR, AND, XOR, NOT;
    }

    class Pair{
        int opTrue;
        int opFalse;

        public Pair(int opTrue, int opFalse){
            this.opTrue = opTrue;
            this.opFalse = opFalse;
        }
    }
    public int minimumFlips(TreeNode root, boolean result) {
        Pair pair = solve(root);

        return result ? pair.opTrue : pair.opFalse;
    }

    private Pair solve(TreeNode root){
        if(root==null) return new Pair(0, 0);

        if(root.right==null && root.left==null){
            return new Pair(
                root.val==Operations.TRUE.ordinal() ? 0 : 1,
                root.val == Operations.FALSE.ordinal() ? 0 :1
            );
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);


        if(root.val == Operations.OR.ordinal()){
            return new Pair(
                Math.min(left.opFalse + right.opTrue, Math.min(left.opTrue + right.opFalse, left.opTrue+ right.opTrue)),
                 left.opFalse + right.opFalse
            );

        }else if(root.val == Operations.AND.ordinal()){
            return new Pair(
                left.opTrue + right.opTrue,
                Math.min(left.opTrue+right.opFalse, Math.min(left.opFalse+right.opTrue, left.opFalse+right.opFalse))
            );

        }else if(root.val == Operations.XOR.ordinal()){
            return new Pair(
                Math.min(left.opTrue+right.opFalse, left.opFalse+right.opTrue),
                Math.min(left.opFalse+right.opFalse, left.opTrue+right.opTrue)
            );
        }else {
            if(root.left!=null){
                return new Pair(
                    left.opFalse,
                    left.opTrue 
                );
            }
            if(root.right!=null){
                return new Pair(
                    right.opFalse,
                    right.opTrue
                );
            }
        }

        return null;

    }
}