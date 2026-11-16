package add_two_numbers_2;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<ListNode> que = new LinkedList<ListNode>();
        int carry = 0;
        int sum = 0;
        int digit = 0;
        while(l1!=null & l2!=null){
            sum = l1.val + l2.val + carry;
            digit = sum%10;
            carry = sum/10;
            que.add(new ListNode(digit));
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
         sum = l1.val  + carry;
            digit = sum%10;
            carry = sum/10;
            que.add(new ListNode(digit));
            l1 = l1.next;   
        }
        while(l2!=null){
             sum = l2.val  + carry;
            digit = sum%10;
            carry = sum/10;
            que.add(new ListNode(digit));
            l2 = l2.next; 
        }
        if(carry==1){
            que.add(new ListNode(carry));
        }
        
        if(que.isEmpty()){
            return null;
        }
        
        ListNode head = que.poll();
        ListNode curr = head;
        while(!que.isEmpty()){
            curr.next = que.poll();
            curr = curr.next;
        }
        return head;
    }
}