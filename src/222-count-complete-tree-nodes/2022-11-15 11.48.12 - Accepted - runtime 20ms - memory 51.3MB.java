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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        int count = 0;
        while(!que.isEmpty()){
             root = que.poll();
            count++;
            if(root.left!=null){
                que.add(root.left);
            }
            if(root.right !=null){
                que.add(root.right);
            }
        }
        return count;
    }
}