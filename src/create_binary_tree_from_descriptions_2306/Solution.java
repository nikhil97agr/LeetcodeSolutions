package create_binary_tree_from_descriptions_2306;

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
    public TreeNode createBinaryTree(int[][] arr) {
        Map<Integer, Integer> par = new HashMap<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        for(int x[] : arr){
            int p = x[0];
            int c = x[1];
            int isLeft = x[2];

            par.put(c, p);
            par.putIfAbsent(p, p);
            map.putIfAbsent(c, new TreeNode(c));
            map.putIfAbsent(p, new TreeNode(p));

            if(isLeft == 1){
                map.get(p).left = map.get(c);
            }else{
                map.get(p).right = map.get(c);
            }
        }

        for(int x : map.keySet()){
            if(par.get(x) == x){
                return map.get(x);
            }
        }
        return null;
    }
}