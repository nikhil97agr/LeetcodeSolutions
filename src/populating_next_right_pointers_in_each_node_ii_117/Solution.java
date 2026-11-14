package populating_next_right_pointers_in_each_node_ii_117;

import java.util.*;
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                Node node = que.poll();
                if(node.left!=null){
                    que.offer(node.left);
                }
                if(node.right!=null){
                    que.offer(node.right);
                }
                if(i!=size-1){
                    node.next = que.peek();
                }
            }
        }
        return root;
    }
}