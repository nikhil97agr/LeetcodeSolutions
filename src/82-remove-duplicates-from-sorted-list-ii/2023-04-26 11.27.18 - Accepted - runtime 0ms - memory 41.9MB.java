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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(-1000);
        if(head==null){
            return null;
        }
        temp.next = head;
        head= temp;
        ListNode curr = head.next;
        ListNode prev = head;
       while(curr!=null && curr.next!=null){
           if(curr.next.val == curr.val){
               while(curr!=null && curr.next!=null && curr.val==curr.next.val){
                   curr = curr.next;
               }
               prev.next = curr.next;
               curr= curr.next;
           }else{
               prev = curr;
               curr = curr.next;
           }
       }

        return head.next;
    }
}