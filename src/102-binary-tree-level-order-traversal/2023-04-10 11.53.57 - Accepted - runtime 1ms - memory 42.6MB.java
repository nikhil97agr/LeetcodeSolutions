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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Queue<TreeNode> temp = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            while(!q.isEmpty()){
                 root = q.poll();
                list.add(root.val);
                if(root.left!=null){
                    temp.add(root.left);
                }
                if(root.right!=null){
                    temp.add(root.right);
                }
            }
            result.add(list);
            q = temp;
        }

        return result;
    }
}