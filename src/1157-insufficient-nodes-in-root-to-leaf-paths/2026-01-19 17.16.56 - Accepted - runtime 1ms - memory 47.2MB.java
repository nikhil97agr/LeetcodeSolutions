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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return solve(root, 0, limit).node;
    }

    private Response solve(TreeNode root, long currSum, long limit){
        if(root == null){
            return new Response(null, Integer.MIN_VALUE);
        }
        currSum += root.val;
        if(root.left == null && root.right == null){
            if(currSum < limit){
                return new Response(null, root.val);
            }else{
                 return new Response(root, root.val);
            }
        }

        Response left = solve(root.left, currSum, limit);
        Response right = solve(root.right, currSum, limit);

        long max = Integer.MIN_VALUE;
        if(left.sum != Integer.MIN_VALUE){
            max = currSum + left.sum;
        }

        if(right.sum != Integer.MIN_VALUE){
            max = Math.max(max, currSum + right.sum);
        }

        if(max  < limit){
            long val = Math.max(left.sum, right.sum) + root.val;
            if(left.node !=null){
                return new Response(left.node, val);
            }

            return new Response(right.node , val);
        }

        root.left = left.node;
        root.right = right.node;

        return new Response(root, Math.max(left.sum, right.sum ) + root.val);

    }

    class Response{
        TreeNode node;
        long sum;
        public Response(TreeNode node, long sum){
            this.sum = sum;
            this.node = node;
        }
    }
}