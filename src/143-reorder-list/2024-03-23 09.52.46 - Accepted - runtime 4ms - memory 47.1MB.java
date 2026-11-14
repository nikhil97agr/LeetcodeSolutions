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
    public void reorderList(ListNode head) {
        Deque<ListNode> que = new LinkedList<>();

        ListNode temp = head;
        while(temp!=null){
            que.offer(temp);
            temp = temp.next;
        }
        temp = null;
        while(!que.isEmpty()){
            if(temp!=null) temp = temp.next;

            ListNode first = que.pollFirst();
            ListNode second = que.pollLast();
            first.next = second;
            if(temp==null){
                temp = first;
            }else{

                temp.next = first;
                temp = temp.next;
            }
        }
        if(temp.next!=null) temp.next.next = null;;
    }
}