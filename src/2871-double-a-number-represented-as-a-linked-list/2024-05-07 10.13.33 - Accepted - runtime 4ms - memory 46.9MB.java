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
    public ListNode doubleIt(ListNode head) {
        int carry = solve(head);
        if(carry != 0){
            ListNode temp = new ListNode(carry);
            temp.next = head;
            head = temp;
        }
        return head;
    }

    public int solve(ListNode head){
        if(head == null) return 0;

        int carry = solve(head.next);

        int val = head.val*2 + carry;
        head.val = val%10;
        carry = val/10;
        return carry;
    }

}