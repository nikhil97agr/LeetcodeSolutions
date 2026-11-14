import java.util.TreeSet;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();

        dfs(root, set);

        if(set.size() == 1) return -1;
        
        set.pollFirst();
        
        
        return set.first();


    }

    private int dfs(TreeNode root, TreeSet<Integer> set){
        if(root.left == null && root.right == null){
            set.add(root.val);

            return root.val;
        }


        int left =dfs(root.left, set);
        int right = dfs(root.right, set);

        set.add(Math.min(left, right));

        return Math.min(left, right);
    }
}