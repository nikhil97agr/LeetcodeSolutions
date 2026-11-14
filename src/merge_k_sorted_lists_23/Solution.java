package merge_k_sorted_lists_23;

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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> que = new PriorityQueue<>((a,b)->{
            return a.val - b.val;
        });
        for(ListNode node : lists){
           if(node!=null) que.offer(node);
        }

        ListNode result = new ListNode(-1);
        ListNode head = result;
        while(!que.isEmpty()){
            ListNode node = que.poll();
            head.next = new ListNode(node.val);
            head = head.next;
            if(node.next!=null){
                que.offer(node.next);
            }
        }
        return result.next;
    }
}