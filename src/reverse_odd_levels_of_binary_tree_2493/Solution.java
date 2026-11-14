package reverse_odd_levels_of_binary_tree_2493;

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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int lvl = 0;
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = que.poll();
                if(node.left != null){
                    que.offer(node.left);
                    list.add(node.left.val);
                }
                if(node.right != null){
                    que.offer(node.right);
                    list.add(node.right.val);
                }
            }

            if(lvl%2==0){
                int ind = list.size()-1;
                size = que.size();
                while(size-- > 0){
                    TreeNode node = que.poll();
                    node.val = list.get(ind);
                    ind--;
                    que.offer(node);
                }
            }
            lvl++;
        }

        return root;
    }
}