package insert_into_a_sorted_circular_linked_list_850;


import java.sql.NClob;// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node curr = head;
        while(true){
            if(curr.val <= insertVal && insertVal <= curr.next.val){
                break;
            }

            if(curr.val > curr.next.val){
                if(insertVal >= curr.val || insertVal <= curr.next.val) break;
            }
            curr = curr.next;

            if(curr == head) break;
        }

        Node node = new Node(insertVal);
        Node next = curr.next;
        curr.next = node;
        node.next = next;

        return head;
    }
}