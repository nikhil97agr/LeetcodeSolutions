package odd_even_linked_list_328;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode temp1 = odd;
        ListNode temp2 = even;
        while(head!=null&&head.next!=null){
            temp1.next=head;
            temp1 = temp1.next;
            temp2.next  = head.next;
            temp2 = temp2.next;
            head = head.next;
            head = head.next;
        }
        if(head!=null){
            temp1.next = head;
            temp1 = temp1.next;
        }
        temp1.next = even.next;
        temp2.next = null;
        return odd.next;
    }
}