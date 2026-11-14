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
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr= head;
        while(curr != null){
            stack.push(curr);
            curr = curr.next;
        }

        while(!stack.isEmpty()){
            if(stack.peek().val != head.val) return false;
            stack.pop();
            head = head.next;
        }
        return true;
    }
}