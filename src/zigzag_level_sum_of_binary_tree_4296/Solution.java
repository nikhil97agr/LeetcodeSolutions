package zigzag_level_sum_of_binary_tree_4296;

import java.util.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {

        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {

        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public List<Long> zigzagLevelSum(TreeNode root) {

        var result = new ArrayList<Long>();
        var que = new ArrayDeque<TreeNode>();

        que.offer(root);
        int level = 1;
        while(!que.isEmpty()) {
            long sum = 0;
            boolean process = true;
            var newQue = new ArrayDeque<TreeNode>();
            if (level % 2 == 1) {
                while (!que.isEmpty()) {
                    TreeNode next = que.pollFirst();
                    if (next.left == null) {
                        process = false;
                    }
                    if (process) {
                        sum += next.val;
                    }
                    if (next.left != null) {
                        newQue.offer(next.left);
                    }
                    if (next.right != null) {
                        newQue.offer(next.right);
                    }
                }
            } else {
                while (!que.isEmpty()) {
                    TreeNode next = que.pollLast();
                    if (next.right == null) {
                        process = false;
                    }

                    if (process) {
                        sum += next.val;
                    }
                    if (next.right != null) {
                        newQue.offerFirst(next.right);
                    }
                    if (next.left != null) {
                        newQue.offerFirst(next.left);
                    }
                }
            }

            que = newQue;
            result.add(sum);
            level++;
        }

        return result;
    }

  
}