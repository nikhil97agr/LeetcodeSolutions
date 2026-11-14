package maximum_level_sum_of_a_binary_tree_1116;

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
    public int maxLevelSum(TreeNode root) {
        int level = 1;
        int max = root.val;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int curr =0;
        while(!que.isEmpty()){
            curr++;
            int sum = 0;
            Queue<TreeNode> temp = new LinkedList<>();
            while(!que.isEmpty()){
                TreeNode node = que.poll();
                sum += node.val;
                if(node.left!=null){
                    temp.add(node.left);
                }
                if(node.right!=null){
                    temp.add(node.right);
                }
            }

            que = temp;
            if(sum > max){
                level = curr;
                max = sum;
            }
        }
        return level;
    }
}