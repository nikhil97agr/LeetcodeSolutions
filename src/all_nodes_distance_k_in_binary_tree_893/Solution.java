package all_nodes_distance_k_in_binary_tree_893;

import java.util.*;
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        if(k==0) {
            list.add(target.val);
            return list;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        Map<Integer, TreeNode> map = new HashMap<>();
        while(!que.isEmpty()){
            int size = que.size();
            while(size>0){
                size--;
                root = que.poll();
                if(root.left!=null){
                    map.put(root.left.val, root);
                    que.add(root.left);
                }
                if(root.right!=null){
                    que.add(root.right);
                    map.put(root.right.val, root);
                }
            }
        }
        Set<TreeNode> visited = new HashSet<>();
        que = new LinkedList<>();
        que.add(target);
        visited.add(target);
        while(k>0 && !que.isEmpty()){
            int size = que.size();
            k--;
            while(size>0){
                size--;
                root = que.poll();
                if(map.get(root.val)!=null && !visited.contains(map.get(root.val))){
                    que.add(map.get(root.val));
                    visited.add(map.get(root.val));
                }

                if(root.left!=null && !visited.contains(root.left)){
                    que.add(root.left);
                    visited.add(root.left);
                } 
                if(root.right!=null && !visited.contains(root.right)){
                     que.add(root.right);
                visited.add(root.right);
                }
            }
        }

        while(!que.isEmpty()){
            list.add(que.poll().val);
        }
        return list;
        
    }
}