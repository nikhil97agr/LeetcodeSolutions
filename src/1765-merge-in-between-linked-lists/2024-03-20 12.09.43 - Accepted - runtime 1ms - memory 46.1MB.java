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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count = 0;
        ListNode curr = new ListNode(-1);
        curr.next = list1;
        ListNode head = curr;
        while(count<a){
            curr = curr.next;
            count++;
        }
        ListNode end = curr.next;
        curr.next = list2;
        while(curr.next!=null){
            curr = curr.next;
        }
        while(count<=b){
            end = end.next;
            
            count++;
        }
        curr.next = end;
        return head.next;
    }
}