package find_duplicate_subtrees_652;

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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();

        List<TreeNode> res = new ArrayList<>();
        solve(root, map, res);
        return res;
    }

    private String solve(TreeNode root, HashMap<String, Integer> map, List<TreeNode> ans){
        if(root==null){
            return "";
        }

        String left = solve(root.left, map, ans);
        String right = solve(root.right, map, ans);

        String curr = ""+root.val+":"+left+":"+right;

        if(map.getOrDefault(curr, 0)==1){
            ans.add(root);
        }

        map.put(curr, map.getOrDefault(curr, 0)+1);
        return curr;
    }
}