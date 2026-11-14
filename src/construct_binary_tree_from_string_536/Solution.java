package construct_binary_tree_from_string_536;

import java.util.*;

import java.util.LinkedList;
import java.util.Queue;

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
    public TreeNode str2tree(String s) {
        if(s.isEmpty()) return null;
        Queue<String> que= new LinkedList<>();

        int i=0;
        int n = s.length();
        while(i < n){
            char c = s.charAt(i);
            if(c == '(' || c== ')'){
                que.offer(Character.toString(c));
                i++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            if(c == '-'){
                sb.append(c);
                i++;
            }
            while(i < n && Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
                i++;
            }

            que.offer(sb.toString());

        }
        return dfs(que);

    }

    private TreeNode dfs(Queue<String> que){
        TreeNode root =new TreeNode( Integer.parseInt(que.poll()));
        boolean left = true;
        while(!que.isEmpty()){
            String s = que.poll();
            if(s.equals(")")){
                break;
            }
            
            if(left){
                root.left = dfs(que);
                left = false;
            }else{
                root.right = dfs(que);
            }
        }
        
        return root;
    }
}