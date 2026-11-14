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
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        root.val = 0;
        int ans =0 ;
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if(node.left == null && node.right == null){
                ans += node.val;
                continue;
            }

            if(node.left != null){
                que.offer(node.left);
            }
            if(node.right != null){
                node.right.val = 0;
                que.offer(node.right);
            }
        }
        return ans;
    }
}