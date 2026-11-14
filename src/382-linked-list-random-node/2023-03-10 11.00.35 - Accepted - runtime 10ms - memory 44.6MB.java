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
    ListNode arr[];
    int size;
    Random r;
    public Solution(ListNode head) {
        r = new Random();
        ListNode temp = head;
        size=0;
        while(temp!=null){
            size++;
            temp= temp.next;
        }

        arr = new ListNode[size];
        temp = head;
        int i =0;
        while(temp!=null){
            arr[i++] = temp;
            temp = temp.next;
        }
    }
    
    public int getRandom() {
        return arr[r.nextInt(size)].val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */