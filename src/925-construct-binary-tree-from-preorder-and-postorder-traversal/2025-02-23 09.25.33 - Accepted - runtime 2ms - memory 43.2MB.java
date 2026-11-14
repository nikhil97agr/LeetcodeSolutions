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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int preInd = 1;
        int postInd = 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.val == postorder[postInd]){
                stack.pop();
                postInd++;
            }else{
                TreeNode temp = new TreeNode(preorder[preInd++]);
                if(node.left==null) node.left = temp;
                else node.right = temp;
                stack.push(temp);
            }

        }
        return root;
    }
}