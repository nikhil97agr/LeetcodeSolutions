package closest_binary_search_tree_value_ii_272;

import java.util.*;
import java.util.stream.*;
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> que = new LinkedList<>();
        dfs(root, target, k, que);
        return que.stream().collect(Collectors.toList());
    }

    private void dfs(TreeNode root, double target, int k, Queue<Integer> list){
        if(root==null) return ;

        dfs(root.left, target, k , list);

        if(list.size()==k){
            if(Math.abs(target - list.peek()) < Math.abs(root.val - target)){
                return ;
            }

            list.poll();
        }

        list.add(root.val);

        dfs(root.right, target, k, list);
    }
}