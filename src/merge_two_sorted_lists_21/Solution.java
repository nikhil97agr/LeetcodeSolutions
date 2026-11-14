package merge_two_sorted_lists_21;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while(list1!=null && list2!=null){
            int val1 = list1.val;
            int val2 = list2.val;
            if(val1<=val2){
                temp.next = new ListNode(val1);
                temp = temp.next;
                list1 = list1.next;
            }else{
                temp.next = new ListNode(val2);
                temp = temp.next;
                list2 = list2.next;
            }
        }

        while(list1 !=null){
            temp.next = new ListNode(list1.val);
            list1 = list1.next;
            temp = temp.next;
        }
             while(list2 !=null){
            temp.next = new ListNode(list2.val);
            list2 = list2.next;
            temp = temp.next;
        }

        return result.next;
    }
}