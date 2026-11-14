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
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                TreeNode next = que.poll();
                if(next == u){
                    if(size ==0) return null;
                    else return que.poll();
                }

                if(next.left!=null) que.offer(next.left);
                if(next.right !=null) que.offer(next.right);
            }
        }



        return null;
    }
}