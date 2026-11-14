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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int x : to_delete) set.add(x);
        TreeNode node = solve(result, root, set);
        if(node!=null) result.add(node);
        return result;
    }

    private TreeNode solve(List<TreeNode> result, TreeNode root, Set<Integer> set){
        if(root == null) return null;

        root.left = solve(result, root.left, set);
        root.right = solve(result, root.right, set);

        if(set.contains(root.val)){
            if(root.left!=null)result.add(root.left);
            if(root.right!=null) result.add(root.right);

            return null;
        }

        return root;
    }
}