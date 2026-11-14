package k_th_largest_perfect_subtree_size_in_binary_tree_3509;

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
    
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        dfs(root, que, k);
        if(que.size() < k) return -1;

        return que.peek();
    }

    private Response dfs(TreeNode root, PriorityQueue<Integer> que, int k){
        if(root ==null){
            return new Response(0, 0);
        }

        Response left = dfs(root.left, que, k);
        Response right = dfs(root.right, que, k);
        if(!left.perfect || !right.perfect){
            Response response = new Response(0, 0);
            response.perfect = false;
            return response;
        }
    if(left.level != right.level){
        Response response = new Response(0, 0);
        response.perfect = false;
        return response;
    }

    Response response = new Response(left.nodes + right.nodes + 1, left.level+1);
    que.offer(response.nodes);

        if(que.size() > k){
            que.poll();
        }

        return response;
    }

    class Response{
        int nodes;
        int level;
        boolean perfect;
        public Response(int nodes, int level){
            this.nodes = nodes;
            this.level = level;
            perfect = true;
        }
    }


}