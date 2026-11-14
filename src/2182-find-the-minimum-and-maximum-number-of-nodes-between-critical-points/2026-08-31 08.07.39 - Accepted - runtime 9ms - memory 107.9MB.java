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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> ind = new ArrayList<>();
        ListNode prev = head;
        head=head.next;
        int i = 0;
        while(head.next!=null){
            if((head.val < prev.val && head.val < head.next.val) || (head.val > prev.val && head.val > head.next.val)){
                ind.add(i);
            }

            i++;
            prev = head;
            head = head.next;
        }
        if(ind.size() <= 1) return new int[]{-1, -1};
        int result[] = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = ind.get(ind.size()-1) - ind.get(0);
        for(i=0;i<ind.size()-1;i++){
            result[0] = Math.min(result[0], ind.get(i+1) - ind.get(i));
        }
        return result;

    }
}