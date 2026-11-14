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
    public ListNode[] splitCircularLinkedList(ListNode list) {
        ListNode fast =list;

        ListNode slow = list;

        fast =fast.next;
        while(fast.next != slow){
            fast = fast.next;
        }
        fast.next = null;
        fast = list;
        slow = list;
        ListNode res[] =new ListNode[2];
        while(fast!=null && fast.next!=null){
            fast =fast.next.next;
            slow = slow.next;
        }

        if(fast !=null){
            slow = slow.next;
        }
        fast = slow;
        while(fast.next!=null) fast = fast.next;
        fast.next = slow;
        res = new ListNode[]{list, slow};
        list = res[0];

        while(list.next!=slow){
            list = list.next;
        }
        list.next = res[0];
        return res;
    }
}