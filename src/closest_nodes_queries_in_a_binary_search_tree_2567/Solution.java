package closest_nodes_queries_in_a_binary_search_tree_2567;

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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> inorder = new ArrayList<>();
        traverse(inorder, root);

        List<List<Integer>> result = new ArrayList<>();

        for(int x : queries){
            int max = maxSearch(x, inorder);
            int min = minSearch(x, inorder);
            result.add(Arrays.asList(min, max));
        }

        return result;

        
    }

    private int maxSearch(int x , List<Integer> inorder){
        int start = 0;
        int end = inorder.size()-1;
        int ans = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(inorder.get(mid)==x) return x;

            if(inorder.get(mid)>x){
                ans = inorder.get(mid);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return ans;
    }
    private int minSearch(int x , List<Integer> inorder){
        int start = 0;
        int end = inorder.size()-1;
        int ans = -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(inorder.get(mid)==x) return x;

            if(inorder.get(mid)<x){
                ans = inorder.get(mid);
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return ans;
    }

    private void traverse(List<Integer> list, TreeNode root){
        if(root==null) return;

        traverse(list, root.left);
        list.add(root.val);
        traverse(list, root.right);
    }
}