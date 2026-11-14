package convert_binary_number_in_a_linked_list_to_integer_1411;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while(head!=null){
            ans = ans<<1;
            if(head.val==1){
                ans = (ans | 1);

            }
            head = head.next;
        }

        return ans;
    }
}