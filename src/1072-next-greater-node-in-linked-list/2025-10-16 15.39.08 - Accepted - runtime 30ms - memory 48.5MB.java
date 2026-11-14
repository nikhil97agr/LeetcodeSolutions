/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        while(head != null){

            while(!stack.isEmpty() && map.get(stack.peek()).val < head.val ){
                m2.put(stack.pop(), head.val);
            }

            map.put(i, head);
            stack.push(i);
            head = head.next;
            i++;     
        }

        int ans[] = new int[i];

        for(int key : m2.keySet()){
            ans[key] = m2.get(key);
        }

        return ans;
    }
}