package binary_tree_level_order_traversal_ii_107;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root!=null)
        que.offer(root);
        
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> l = new ArrayList<>();
            while(size-->0){
                TreeNode node = que.poll();
                l.add(node.val);
                if(node.left!=null) que.offer(node.left);
                if(node.right!=null) que.offer(node.right);
            }
            
            list.add(l);
            
        }
        
        Collections.reverse(list);
        return list;
    }
}