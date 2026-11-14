package flatten_binary_tree_to_linked_list_114;

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