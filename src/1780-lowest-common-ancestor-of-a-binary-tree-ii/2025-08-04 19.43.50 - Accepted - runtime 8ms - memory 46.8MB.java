/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean pfound= false;
    boolean qfound =false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null) return null;
        if(root.val == p.val) pfound = true;
        if(root.val == q.val) qfound = true;
        TreeNode left = solve(root.left, p, q);
        TreeNode right = solve(root.right, p, q);
        if(!pfound || !qfound) return null;
        if(root.val == p.val || q.val == root.val) return root;
        if(left ==null) return right;
        if(right ==null) return left;

        return root;
    }

    private TreeNode solve(TreeNode root, TreeNode p, TreeNode q){
        if(root ==null)return null;
        TreeNode left = solve(root.left, p, q);
        TreeNode right = solve(root.right, p, q);
        if(root.val == p.val){
            pfound = true;
            return p;
        }

        if(root.val == q.val){
            qfound = true;
            return q;
        }



        if(left ==null) return right;
        if(right ==null) return left;
        return root;
    }
}