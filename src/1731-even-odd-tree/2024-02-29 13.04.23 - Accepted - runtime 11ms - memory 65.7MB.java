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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int lvl = 0;
        boolean valid = true;
        while(!que.isEmpty()){
            int size = que.size();
            TreeNode prev = que.poll();
            if((lvl%2==0 && prev.val%2==0) || (lvl%2==1 && prev.val%2==1)){
                valid = false;
                break;
            }
            if(prev.left != null){
                que.offer(prev.left);
            }
            if(prev.right!=null){
                que.offer(prev.right);
            }
            
            while(size > 1){
                TreeNode x = que.poll();
                if(lvl%2==0){
                    if(x.val%2 != 1 || x.val <= prev.val){
                        valid = false;
                        break;
                    }
                }else if(lvl%2==1){
                    if(x.val%2!=0 || x.val >= prev.val){
                        valid = false;
                        break;
                    }
                }
                if(x.left != null){
                    que.offer(x.left);
                }
                if(x.right!=null){
                    que.offer(x.right);
                }
                prev = x;
                size--;
            }
            if(!valid)break;
            lvl++;
        }
        return valid;
    }
}