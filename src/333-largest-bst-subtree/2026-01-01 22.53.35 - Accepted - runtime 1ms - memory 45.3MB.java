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
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return solve(root).size;
    }

    private Result solve(TreeNode root) {
        if (root == null) {
            return new Result(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result left = solve(root.left);
        Result right = solve(root.right);
        
        if(left.isBst && right.isBst && left.max < root.val && right.min > root.val ){
            return new Result(
                true,
                left.size + right.size + 1,
                Math.min(left.min == Integer.MIN_VALUE ? root.val : left.min, root.val),
                Math.max(right.max == Integer.MAX_VALUE ? root.val : right.max, root.val)
            );
        }

        return new Result(
            false,
            Math.max(left.size, right.size),
            0,0
        );
    }



    class Result {
        boolean isBst;
        int size;
        int min;
        int max;

        public Result(boolean isBst, int size, int min, int max) {
            this.isBst = isBst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}