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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head!=null){
            stack.push(head);
            head = head.next;
        }
        int max = 0;
        ListNode res = new ListNode(-1);
        while(!stack.isEmpty()){
            ListNode temp = stack.pop();
            if(temp.val >= max){
                max = temp.val;
            }else{
                continue;
            }
            temp.next = res.next;
            res.next = temp;
        }
        return res.next;
    }
}