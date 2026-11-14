package remove_duplicates_from_an_unsorted_linked_list_1982;

import java.util.*;
import java.util.stream.*;
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode node = head;
        while(head!=null){
            map.merge(head.val, 1, Integer::sum);
            head = head.next;
        }
        Set<Integer> set = map.entrySet().stream().filter(entry -> entry.getValue() == 1).map(x-> x.getKey()).collect(Collectors.toSet());
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        while(node!=null){
            if(set.contains(node.val)){
                temp.next = new ListNode(node.val);
                temp = temp.next;
            }
            node = node.next;
        }

        return res.next;
    }
}