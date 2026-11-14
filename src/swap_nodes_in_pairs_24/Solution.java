package swap_nodes_in_pairs_24;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode curr = temp;
        while(curr.next!=null && curr.next.next!=null){
            ListNode node = curr.next;
            ListNode node2 = curr.next.next;
            ListNode t = node2.next;
            node.next = t;
            node2.next = node;
            curr.next = node2;
            curr= curr.next.next;
        }

        return temp.next;
    }
}