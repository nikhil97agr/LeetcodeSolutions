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
    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Integer> leftHeight = new HashMap<>();
        Map<Integer, Integer> rightHeight = new HashMap<>();

        calculateHeights(root, leftHeight, rightHeight);
        Map<Integer, Integer> height = new HashMap<>();
        solve(root.left, rightHeight.get(root.val), 1, height, leftHeight, rightHeight);
        solve(root.right, leftHeight.get(root.val), 1, height, leftHeight, rightHeight);
        int m = queries.length;
        int ans[] = new int[m];
        for(int i=0;i<m;i++){
            ans[i] = height.get(queries[i]);
        }
        return ans;
    }

    private void solve(TreeNode root, int currMaxH, int depth, Map<Integer,Integer> height, Map<Integer, Integer> lHeight, Map<Integer, Integer> rHeight){
        if(root==null) return;

        height.put(root.val, currMaxH);

        solve(root.left, Math.max(currMaxH, rHeight.get(root.val)+depth), depth+1, height, lHeight, rHeight);
        solve(root.right, Math.max(currMaxH, lHeight.get(root.val)+depth), depth+1, height, lHeight, rHeight);
    }

    private int calculateHeights(TreeNode root, Map<Integer, Integer> leftHeight, Map<Integer, Integer> rightHeight){
        if(root==null) return 0;

        int l = calculateHeights(root.left, leftHeight, rightHeight);
        int r = calculateHeights(root.right, leftHeight, rightHeight);

        leftHeight.put(root.val, l);
        rightHeight.put(root.val, r);

        return Math.max(l, r)+1;
    }
}