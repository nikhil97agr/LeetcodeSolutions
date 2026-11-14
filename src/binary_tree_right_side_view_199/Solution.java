package binary_tree_right_side_view_199;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> que= new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode node = que.peek();
            result.add(node.val);
            Queue<TreeNode> temp = new LinkedList<>();
            while(!que.isEmpty()){
                node =que.poll();
                if(node.right!=null){
                    temp.add(node.right);
                }
                if(node.left!=null){
                    temp.add(node.left);
                }
            }
            que = temp;
        }
        return result;
    }


}