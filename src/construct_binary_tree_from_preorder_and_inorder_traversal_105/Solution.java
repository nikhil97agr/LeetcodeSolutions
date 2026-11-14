package construct_binary_tree_from_preorder_and_inorder_traversal_105;

import java.util.*;
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return build(0, 0, inorder.length-1, preorder, inorder, map);
    }

    private TreeNode build(int pInd, int start, int end, int pre[], int in[], Map<Integer, Integer> map){
        if(pInd >= pre.length || start > end) return null;

        TreeNode root = new TreeNode(pre[pInd]);

        int ind = map.get(root.val);

        root.left = build(pInd+1, start, ind-1, pre, in, map);
        root.right = build(pInd + ind - start + 1, ind+1, end, pre, in, map);

        return root;
    }
}