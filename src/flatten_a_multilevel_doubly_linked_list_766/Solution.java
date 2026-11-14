package flatten_a_multilevel_doubly_linked_list_766;

import java.util.*;
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }
};

class Solution {
    public Node flatten(Node head) {
        Node res = new Node(-1);
        Node curr = res;
        if(head==null) return head;
        Stack<Node> stack = new Stack<>();
        stack.push(head);

        while(!stack.isEmpty()){
            Node node = stack.pop();

            if(node.next!=null){
                stack.push(node.next);
            }

            if(node.child!=null){
                stack.push(node.child);
            }

            curr.next = node;
            node.prev = curr;
            curr= curr.next;
            curr.child = null;
            curr.next = null;
        }

        Node node = res.next;
        node.prev = null;



        return node;
    }
}