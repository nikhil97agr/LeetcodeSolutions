package middle_of_the_linked_list_908;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
public ListNode middleNode(ListNode head) {
            ListNode slow = head;
                    while(head!=null && head.next!=null){
                                head = head.next.next;
                                            slow = slow.next;
                                                    }
                                                            return slow;
                                                                    
                                                                        }

}