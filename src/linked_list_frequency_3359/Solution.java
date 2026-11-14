package linked_list_frequency_3359;

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
    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();

        while(head !=null){
            map.merge(head.val, 1, Integer::sum);
            head = head.next;
        }

        head= new ListNode(-1);
        ListNode curr =head;

        for(int val : map.values()){
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return head.next;
    }
}