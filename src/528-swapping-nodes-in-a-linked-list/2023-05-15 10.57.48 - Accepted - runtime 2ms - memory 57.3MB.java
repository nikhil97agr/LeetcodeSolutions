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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        ListNode curr = head;
        int cnt = 1;
        while(curr!=null){
            if(cnt<k) left = left.next;
            if(cnt>k) right = right.next;

            curr = curr.next;
            cnt++;
        }

        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }
}