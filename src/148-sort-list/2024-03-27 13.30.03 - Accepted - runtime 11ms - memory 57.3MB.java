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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode curr = null;
        ListNode slow = head, fast = head;

        while(fast!=null && fast.next!=null){
            curr = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        curr.next = null;

        ListNode left =  sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode res = new ListNode(-1);
        ListNode curr = res;

        while(left!=null && right!=null){
            if(left.val < right.val){
                curr.next = left;
                left = left.next;
                curr = curr.next;
                curr.next = null;
            }else{
                curr.next = right;
                right = right.next;
                curr = curr.next;
                curr.next = null;
            }
        }

        if(left !=null) curr.next = left;
        if(right!=null) curr.next = right;


        return res.next;
    }
}