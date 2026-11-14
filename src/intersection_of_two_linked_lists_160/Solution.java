package intersection_of_two_linked_lists_160;

import java.util.*;
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while(headA!=null){
            set.add(headA);
            headA = headA.next;
        }

        while(headB!=null){
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}