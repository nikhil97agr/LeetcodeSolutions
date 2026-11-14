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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
     
      
        if(root1 == null) return false;
        
        
        int needed = target - root1.val;
        TreeNode node = root2;
        
        while(node !=null){
            
            if(node.val == needed) return true;
            else if(needed < node.val) node = node.left;
            else node = node.right;
            
            
        }
        
        
        
        return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
        
        
        
        
        
        
        
        
        
    }
}