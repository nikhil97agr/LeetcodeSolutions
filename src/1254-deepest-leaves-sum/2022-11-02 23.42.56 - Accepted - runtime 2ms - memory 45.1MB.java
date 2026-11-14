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
    public int deepestLeavesSum(TreeNode root) {
        int height = calc(root);
        int sum = calcSum(root, height);
        return sum;
    }
    
    public int calcSum(TreeNode root, int height){
         if(root==null){
            return 0;
        }
        if(height==1){
            return root.val;
        }
       
        return calcSum(root.left, height-1) + calcSum(root.right, height-1);
    }
    
    public int calc(TreeNode root){
        if(root==null){
            return 0;
        }
        
        return 1 + Math.max(calc(root.left), calc(root.right));
    }
}