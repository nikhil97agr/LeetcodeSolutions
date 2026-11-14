package correct_a_binary_tree_1796;

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
    public TreeNode correctBinaryTree(TreeNode root) {
        Map<Integer, Set<TreeNode>> map = new HashMap<>();

        int level = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            Set<TreeNode> set = new HashSet<>();
            int size = que.size();
            while(size-->0){
                TreeNode node = que.poll();
                set.add(node);
                if(node.left!=null){
                    que.offer(node.left);
                }

                if(node.right!=null){
                    que.offer(node.right);
                }
            }

            map.put(level, set);
            level++;
        }

        return dfs(root, 0, map);
    }

    private TreeNode dfs(TreeNode root, int level, Map<Integer, Set<TreeNode>> map){
        if(root==null || (root.left ==null && root.right == null)) return root;

        root.left = dfs(root.left, level+1, map);

        if(root.right !=null){
            TreeNode node = root.right;

            if(map.get(level).contains(node)){
                return null;
            }

            root.right = dfs(root.right, level+1, map);
        }

        return root;


    }
}