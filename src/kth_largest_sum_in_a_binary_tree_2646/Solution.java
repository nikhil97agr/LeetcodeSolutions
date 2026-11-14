package kth_largest_sum_in_a_binary_tree_2646;

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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root!=null)
        que.offer(root);

        while(!que.isEmpty()){
            long sum = 0;
            int size = que.size();

            while(size-- > 0){
                root = que.poll();
                sum += root.val;

                if(root.left!=null) que.offer(root.left);
                if(root.right != null) que.offer(root.right);
            }
            pq.offer(sum);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.size()< k ? -1 : pq.peek();
    }
}