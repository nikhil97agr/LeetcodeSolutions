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
    public int findBottomLeftValue(TreeNode root) {
        int ans = root.val;
        int currLevel = 0;
        Queue<Object[]> queue = new LinkedList<Object[]>();
        queue.add(new Object[]{root, 0});
        while(!queue.isEmpty()){
            Object[] obj = queue.poll();
            TreeNode node = (TreeNode)obj[0];
            int level = (Integer)obj[1];
            if(currLevel!=level){
                currLevel = level;
                ans = node.val;
            }
            if(node.left!=null){
                queue.add(new Object[]{node.left, level+1});
            }
            if(node.right!=null){
                queue.add(new Object[]{node.right, level+1});
            }
        }

        return ans;
    }
}