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
    public int minimumLevel(TreeNode root) {
        long sum = Long.MAX_VALUE;
        int ans = 0;
        int l = 1;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            long s= 0;
            int size= que.size();
            while(size-->0){
                root = que.poll();
                s += root.val;

                if(root.left !=null) que.offer(root.left);
                if(root.right !=null) que.offer(root.right);
            }
            if(s < sum){
                sum = s;
                ans = l;
            }
            l++;
        }

        return ans;
    }
}