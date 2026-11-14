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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode curr= res;
        while(head.next!=null){
            curr.next = head;
            head = head.next;
            curr = curr.next;

            curr.next = new ListNode(gcd(head.val, curr.val));
            curr = curr.next;
        }

        curr.next = head;
        return res.next;
    }

    private int gcd(int a, int b){
        if(b==0) return a;

        return gcd(b, a%b);
    }
}