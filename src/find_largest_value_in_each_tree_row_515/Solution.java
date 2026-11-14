package find_largest_value_in_each_tree_row_515;

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int ans = Integer.MIN_VALUE;
            int size = que.size();
            while(size-- > 0){
                TreeNode node = que.poll();
                ans = Math.max(ans, node.val);
                if(node.left!=null) que.offer(node.left);
                if(node.right!=null) que.offer(node.right);
            }

            list.add(ans);
        }

        return list;
    }
}