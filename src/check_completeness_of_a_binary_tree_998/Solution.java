package check_completeness_of_a_binary_tree_998;

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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        int nullCount = 0;
        
        while(!que.isEmpty()){
            TreeNode curr =que.remove();
            if(curr==null){
                nullCount--;
                if(nullCount==que.size()){
                    return true;
                }
                return false;
            }
            que.add(curr.left);
            que.add(curr.right);
            if(curr.left==null){
                nullCount++;
            }
            if(curr.right==null){
                nullCount++;
            }
            
        }
        return true;
    }
    
    
}