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

    class Node{
        boolean isValid;
        int min;
        int max;
        int sum;
        Node left;
        Node right;

        public Node(int min, int max, int sum, boolean isValid){
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.isValid = isValid;
        }
    }
    int ans = 0;
    public int maxSumBST(TreeNode root) {
        
        validate(root);
        
        return ans;
    }

    private Node validate(TreeNode root){
        if(root==null) return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);

        Node left = validate(root.left);
        Node right = validate(root.right);

        if(left.isValid && right.isValid && root.val > left.max && root.val < right.min){
            Node node = new Node(root.val, root.val, root.val, true);
            node.min = Math.min(node.min, Math.min(left.min, right.min));
            node.max = Math.max(node.max, Math.max(left.max, right.max));
            node.sum = node.sum + left.sum + right.sum;
            ans = Math.max(ans, node.sum);
            return node;
        }else{
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, false);
        }
    }
}