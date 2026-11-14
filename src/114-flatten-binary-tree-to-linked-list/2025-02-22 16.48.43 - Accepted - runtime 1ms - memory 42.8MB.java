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
    public void flatten(TreeNode root) {
        if(root == null) return ;

        Deque<TreeNode> que = new LinkedList<>();
        que.offerFirst(root.right);
        que.offerFirst(root.left);
        while(!que.isEmpty()){
            TreeNode temp = que.pollFirst();

            if(temp==null) continue;
            root.left = null;
            root.right = temp;
            que.offerFirst(temp.right);
            que.offerFirst(temp.left);
            root = root.right;
        }
    }
}