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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        List<ListNode> list = new ArrayList<>();
        while(head!=null){
            list.add(head);
            head = head.next;
        }
        int n = list.size();
        ListNode res[] = new ListNode[list.size()];
        for(int i=0;i<list.size();i++){
            res[(i+k)%n] = list.get(i);
        }

        res[n-1].next = null;

        head = res[0];
        ListNode temp = head;
        for(int i=1;i<n;i++){
            temp.next = res[i];
            temp = temp.next;
        }
        return head;
    }
}