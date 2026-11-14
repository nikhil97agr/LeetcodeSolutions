package reverse_nodes_in_even_length_groups_2196;

import java.util.*;
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        int nextSize = 1;
        while(head !=null){
            Queue<ListNode> que = new LinkedList<>();
            while(que.size() < nextSize && head !=null){
                ListNode node = head;
                head = head.next;
                node.next = null;
                que.offer(node);
            }

            ListNode next = generate(que);
            curr.next = next;
            while(curr.next!=null) curr = curr.next;
            nextSize++;
        }

        return res.next;
    }

    private ListNode generate(Queue<ListNode> que){
        int size = que.size();
        ListNode res = null;
        if(size %2==0){
            while(!que.isEmpty()){
                ListNode node = que.poll();
                node.next = res;
                res = node;
            }
        }else{
            ListNode curr = null;
            while(!que.isEmpty()){
                if(res == null) {
                    res = que.poll();
                    curr = res;
                }else{
                    curr.next = que.poll();
                    curr = curr.next;
                }
            }
        }


        return res;
    }
}