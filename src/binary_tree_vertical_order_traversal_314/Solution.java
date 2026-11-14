package binary_tree_vertical_order_traversal_314;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<Node> que = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        que.offer(new Node(root, 0));

        while(!que.isEmpty()){
            int size= que.size();
            while(size-- > 0){
                Node node = que.poll();
                root = node.node;
                int ind = node.index;
                map.computeIfAbsent(ind, x-> new ArrayList<>()).add(root.val);

                if(root.left!=null) que.offer(new Node(root.left, ind - 1));
                if(root.right !=null) que.offer(new Node(root.right, ind +1));
            }


        }

        return map.entrySet().stream().sorted((a,b)-> a.getKey() - b.getKey()).map(Map.Entry::getValue).toList();
    }

    class Node{
        TreeNode node;
        int index;

        public Node(TreeNode node, int index){
            this.node= node;
            this.index = index;
        }
    }
}