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
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return root;
        TreeNode res = new TreeNode(root.val);
        solve(root, res, 0);
        return res;
    }

    private int solve(TreeNode root, TreeNode node, int currSum){


        if(root.right!=null){
            TreeNode right = new TreeNode(root.right.val);
            currSum = solve(root.right, right, currSum);
            node.right = right;
        }
        node.val += currSum;
        currSum += root.val;

        if(root.left!=null){
            TreeNode left = new TreeNode(root.left.val);
            currSum = solve(root.left, left, currSum);
            node.left = left;
        }



        return currSum;
    }


}