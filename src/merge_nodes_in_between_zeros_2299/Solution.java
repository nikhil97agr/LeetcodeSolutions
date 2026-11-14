package merge_nodes_in_between_zeros_2299;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        while(head!=null){
            if(head.val == 0){
                if(sum != 0){
                    curr.next = new ListNode(sum);
                    curr = curr.next;
                    sum = 0;
                }
            }else{
                sum += head.val;
            }
            head = head.next;
        }

        if(sum !=0){
            curr.next = new ListNode(sum);
            
        }
        return result.next;
    }
}