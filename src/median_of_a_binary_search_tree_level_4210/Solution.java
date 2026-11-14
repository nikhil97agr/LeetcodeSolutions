package median_of_a_binary_search_tree_level_4210;

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
    public int levelMedian(TreeNode root, int level) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty() && level-- > 0){
            int size= que.size();
            while(size-- > 0){
                TreeNode next= que.poll();
                if(next.left !=null){
                    que.offer(next.left);
                }
                if(next.right !=null) {
                    que.offer(next.right);
                }
            }
        }
        if(que.isEmpty()){
            return -1;
        }
        List<Integer> result = new ArrayList<>();
        while(!que.isEmpty()){
            result.add(que.poll().val);
        }

        Collections.sort(result);
        int size =result.size();
        return result.get(size / 2);
    }
}