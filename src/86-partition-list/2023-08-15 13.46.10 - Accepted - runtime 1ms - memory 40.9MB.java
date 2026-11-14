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
        public ListNode partition(ListNode head, int x) {
        Queue<Integer> small = new LinkedList<>();
        Queue<Integer> large = new LinkedList<>();
        while(head!=null){
            if(head.val < x){
                small.add(head.val);
            }else{
                large.add(head.val);
            }
            head = head.next;
        }

        head = new ListNode(-1);
        ListNode temp = head;
        while(!small.isEmpty()){
            temp.next = new ListNode(small.poll());
            temp = temp.next;
        }
        while(!large.isEmpty()){
            temp.next = new ListNode(large.poll());
            temp = temp.next;
        }
        return head.next;
    }
}