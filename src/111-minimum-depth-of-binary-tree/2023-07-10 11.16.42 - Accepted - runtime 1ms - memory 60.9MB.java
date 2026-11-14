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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> que = new LinkedList<>();
        int depth = 1;
        que.add(root);
        while(!que.isEmpty()){
            int n = que.size();
            for(int i=0;i<n;i++){
                root = que.poll();
                if(root.left == null && root.right==null) return depth;
                if(root.left!=null) que.add(root.left);
                if(root.right!=null) que.add(root.right);
            }
            depth++;
        }
        return depth;
    }
}