/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = curr;
        while(head !=null){
            if(head.val < 0 &&  head.val <= curr.val && head != prev){
                ListNode next = head.next;
                prev.next = head.next;
                head.next = curr;
                curr = head;
                head = next;
                continue;
            }

            prev = head;
            head = head.next;
        }

        return curr;
    }
}