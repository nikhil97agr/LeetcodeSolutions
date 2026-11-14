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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int child[] = new int[n];
        dfs(root, child);
        
        if(root.val == x){
            int max = 0;
            if(root.left !=null){
                max = child[root.left.val - 1];
            }

            if(root.right !=null){
                max = Math.max(child[root.right.val - 1], max);
            }

            int left = child[root.val - 1] - max;
            if(max > left) return true;
            return false;
        }
        int total = child[root.val - 1] - child[x-1];

        if(total > child[x-1]) return true;
        TreeNode node = find(root, x);
        int max = 0;
        if(node.left !=null){
            max = child[node.left.val - 1];

        }
        if(node.right !=null){
            max = Math.max(child[node.right.val - 1], max);
        }
        int left = child[root.val - 1] - max;

        if(max > left) return true;
        return false;
    }

    private TreeNode find(TreeNode root, int val){
        if(root == null) return null;
        if(root.val == val) return root;

        TreeNode left = find(root.left, val);
        if(left !=null) return left;
        TreeNode right = find(root.right, val);
        return right;
    }

    private int dfs(TreeNode root, int child[] ){
        if(root==null) return 0;

        int left = dfs(root.left, child);
        int right = dfs(root.right, child);
        int total = left + right + 1;

        child[root.val - 1] = total;
        return total;
    }
}