package maximum_twin_sum_of_a_linked_list_2236;

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
    public int pairSum(ListNode head) {
        int max = 0;
        ListNode node = head;
        Stack<ListNode> stack = new Stack<>();
        while(node!=null){
            stack.push(node);
            node = node.next;
        }
        while(!stack.isEmpty()){
            max = Math.max(stack.pop().val + head.val, max);
            head = head.next;
        }
        return max;
    }
}