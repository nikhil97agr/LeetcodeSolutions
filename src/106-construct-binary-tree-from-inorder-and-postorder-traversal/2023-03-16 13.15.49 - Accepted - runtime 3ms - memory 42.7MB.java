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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;

        return buildTree(inorder, postorder, 0, n-1, 0, n-1);
    }

    private TreeNode buildTree(int in[], int post[], int istart, int iend, int pstart, int pend){
        if(istart>iend){
            return null;
        }

        TreeNode node = new TreeNode(post[pend]);

        if(istart==iend){
            return node;
        }

        int iidx = find(in, istart, iend, node.val);

        node.left = buildTree(in, post, istart, iidx-1, pstart, pstart + iidx-istart-1);

        node.right = buildTree(in, post, iidx+1, iend, pend + iidx-iend, pend-1);

        return node;
    }

    private int find(int in[], int i, int j, int val){

        for(;i<=j;i++){
            if(in[i]==val){
                return i;
            }
        }
        return -1;
    }
}