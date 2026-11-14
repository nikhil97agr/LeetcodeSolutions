package find_mode_in_binary_search_tree_501;

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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        calculate(root, map);
        int max = 0;
        for(int key : map.values()){
            max = Math.max(max, key);
        }

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }
        int ans [] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }

        return ans;
    }

    private void calculate(TreeNode root, Map<Integer, Integer> map){
        if(root==null) return;

        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        calculate(root.left, map);
        calculate(root.right, map);
    }
}