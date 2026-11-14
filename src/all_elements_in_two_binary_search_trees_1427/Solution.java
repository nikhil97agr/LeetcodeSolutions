package all_elements_in_two_binary_search_trees_1427;

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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<Integer>();
        solve(result, root1);
        solve(result, root2);

        Collections.sort(result);
        return result;
    }

    public void solve(List<Integer> result, TreeNode root){
        if(root==null){
            return;
        }

        solve(result, root.left);
        solve(result, root.right);
        result.add(root.val);
    }
}