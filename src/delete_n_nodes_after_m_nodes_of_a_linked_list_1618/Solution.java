package delete_n_nodes_after_m_nodes_of_a_linked_list_1618;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode res = new ListNode(-1);
        ListNode curr = res;

        while(head!=null){
            int c1 = 0;
            int c2 = 0;

            while(head!=null && c1 < m){
                curr.next = head;
                head = head.next;
                curr= curr.next;
                curr.next = null;
                c1++;
            }

            while(head!=null && c2 < n){
                head = head.next;
                c2++;
            }
        }

        return res.next;
    }
}