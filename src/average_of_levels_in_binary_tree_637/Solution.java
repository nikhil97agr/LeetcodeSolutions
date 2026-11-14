package average_of_levels_in_binary_tree_637;

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list= new ArrayList<>();

        Queue<TreeNode> que = new LinkedList<>();
        if(root!=null) que.offer(root);

        while(!que.isEmpty()){
            int cnt = que.size();
            int size = que.size();
            double sum = 0;
            while(size--> 0){
                root = que.poll();
                sum += root.val;

                if(root.left!=null) que.offer(root.left);
                if(root.right!=null) que.offer(root.right);
            }
            list.add(sum/cnt);
        }

        return list;
    }
}