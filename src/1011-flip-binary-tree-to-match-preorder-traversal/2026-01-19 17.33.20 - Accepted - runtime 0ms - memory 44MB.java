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
    int ind = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> result = new ArrayList<>();

        dfs(root, voyage, result);

        return result;
    }

    private boolean dfs(TreeNode root, int voyage[], List<Integer> result) {
        if (root == null)
            return true;

        if (root.val != voyage[ind++]) {
            result.clear();
            result.add(-1);
            return false;
        }

        if (root.left != null && ind < voyage.length && root.left.val != voyage[ind]) {
            result.add(root.val);

            if (!dfs(root.right, voyage, result)) {
                return false;
            }

            if (!dfs(root.left, voyage, result)) {
                return false;
            }

        } else {
            if (!dfs(root.left, voyage, result))
                return false;
            if (!dfs(root.right, voyage, result))
                return false;
        }

        return true;
    }
}