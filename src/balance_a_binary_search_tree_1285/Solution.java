package balance_a_binary_search_tree_1285;

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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        construct(root, inorder);
        return construct(inorder, 0, inorder.size()-1);
    }
    private void construct(TreeNode root, List<Integer> inorder){
        if(root == null) return;

        construct(root.left, inorder);
        inorder.add(root.val);
        construct(root.right, inorder);
    }

    private TreeNode construct(List<Integer> inorder, int start, int end){
        if(start > end) return null;

        if(start == end) return new TreeNode(inorder.get(start));
        int mid = (start + end)/2;

        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = construct(inorder, start, mid-1);
        root.right = construct(inorder, mid+1, end);

        return root;
    }
}