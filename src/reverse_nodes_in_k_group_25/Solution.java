package reverse_nodes_in_k_group_25;

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
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode res = new ListNode(-1);
        ListNode resCurr = res;
        ListNode curr =head;
        ListNode temp = curr;
        while(curr!=null){
            int cnt = 0;
            temp =curr;
            while(curr != null && cnt < k){
                cnt++;
                stack.push(curr);
                curr = curr.next;
            }

            if(cnt != k){
                resCurr.next = temp;
                break;
            }

            while(!stack.isEmpty()){
                resCurr.next = stack.pop();
                resCurr = resCurr.next;
                resCurr.next = null;
            }
        }
        return res.next;
    }
}