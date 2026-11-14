package linked_list_components_835;

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
    public int numComponents(ListNode head, int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();

        for(int x : nums) set.add(x);
        boolean prev= false;
        while(head != null){
            int val = head.val;
            if(set.contains(val) && !prev){
                prev = true;
                ans++;
            }else if(!set.contains(val)){
                prev= false;
            }
            head = head.next;
        }

        return ans;
    }
}