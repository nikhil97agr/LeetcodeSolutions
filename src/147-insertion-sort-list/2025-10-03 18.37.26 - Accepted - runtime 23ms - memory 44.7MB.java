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
    public ListNode insertionSortList(ListNode head) {
        ListNode res = new ListNode(-5001);

        Queue<ListNode> curr = new LinkedList<>();
        while(head!=null){
            curr.offer(head);
            head = head.next;
        }

        while(!curr.isEmpty()){
            head = curr.poll();
            ListNode node = res;
            while(node.next!=null){
                if(head.val >= node.val && head.val < node.next.val){
                    break;
                }
                node = node.next;
            }

            ListNode l = node.next;
            node.next = head;
            head.next = l;
        }


        return res.next;
    }
}