package plus_one_linked_list_369;

import java.util.*;
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node =  head;
        while(node!=null){
            stack.push(node);
            node = node.next;
        }
        int carry =1;
        while(!stack.isEmpty()){
            node = stack.pop();
            node.val += carry;
            carry = node.val/10;
            node.val %=10;
        }

        if(carry>= 1){
            return new ListNode(carry, head);
        }


        return head;
    }
}