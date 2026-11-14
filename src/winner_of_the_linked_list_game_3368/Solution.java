package winner_of_the_linked_list_game_3368;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public String gameResult(ListNode head) {
        int odd = 0;
        int even = 0;

        while(head !=null){
            int e = head.val;
            int o = head.next.val;
            head = head.next.next;

            if(e > o) even++;
            else if(o >e)odd++;
        }

        if(even == odd){
            return "Tie";
        }else if(even > odd){
            return "Even";
        }else{
            return "Odd";
        }
    }
}