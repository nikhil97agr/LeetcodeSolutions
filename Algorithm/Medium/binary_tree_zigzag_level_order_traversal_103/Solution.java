package binary_tree_zigzag_level_order_traversal_103;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){
            return result;
        }
        stack.push(root);
        List<Integer> l = new ArrayList<>();
        l.add(root.val);
        result.add(l);
        boolean isRight = true;
        while(!stack.isEmpty()){
            Stack<TreeNode> temp = new Stack<>();
            List<Integer> r1 = new ArrayList<>();
            while(!stack.isEmpty()){
                if(isRight){
                    TreeNode node = stack.pop();
                    if(node.right!=null){
                        temp.push(node.right);
                        r1.add(node.right.val);
                    }
                    if(node.left!=null){
                        temp.push(node.left);
                        r1.add(node.left.val);
                    }
                }else{
                    TreeNode node = stack.pop();
                    if(node.left!=null){
                        temp.push(node.left);
                        r1.add(node.left.val);
                    }
                    if(node.right!=null){
                        temp.push(node.right);
                        r1.add(node.right.val);
                    }
                }
            }

            stack = temp;
            if(!r1.isEmpty())
            result.add(r1);
            isRight = !isRight;
        }
        return result;
    }

}