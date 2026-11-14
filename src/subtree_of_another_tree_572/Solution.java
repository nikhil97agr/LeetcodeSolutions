package subtree_of_another_tree_572;

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> que= new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            TreeNode next = que.poll();

            if(check(next, subRoot)){
                return true;
            }

            if(next.left!=null) que.offer(next.left);
            if(next.right!=null) que.offer(next.right);
        }

        return false;
    }

    private boolean check(TreeNode root, TreeNode sub){
        if(root == null && sub == null) return true;

        if(root == null || sub == null) return false;


        if(root.val != sub.val) return false;

        return check(root.left, sub.left) && check(root.right, sub.right);
    }
}