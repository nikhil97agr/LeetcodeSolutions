package alt_and_tab_simulation_3538;

import java.util.*;
class Solution {
    class Node{
        Node next;
        Node prev;
        int val;
        public Node(int val){
            this.val = val;
        }
    }
    public int[] simulationResult(int[] windows, int[] queries) {
        Node head = new Node(-1), tail=new Node(-1);
        head.next = tail;
        tail.prev = head;

        Map<Integer, Node> map = new HashMap<>();
        for(int x : windows){
            Node node = new Node(x);
            map.put(x, node);
            Node prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            tail.prev = node;
            node.next = tail;
        }

        for(int q : queries){
            Node node = map.get(q);
            Node prev = node.prev;
            node.next.prev = prev;
            prev.next = node.next;

            Node next = head.next;
            head.next = node;
            node.prev = head;
            next.prev = node;
            node.next = next;
        }
        int ans[] = new int[windows.length];
        int ind = 0;
        while(head.next != tail){
            ans[ind++] = head.next.val;
            head = head.next;
        }

        return ans;
    }
}