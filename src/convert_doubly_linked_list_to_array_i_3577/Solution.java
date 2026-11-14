package convert_doubly_linked_list_to_array_i_3577;

import java.util.*;
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};

class Solution {
    public int[] toArray(Node head) {
        List<Integer> ans = new ArrayList<>();
        while(head!=null){
            ans.add(head.val);
            head = head.next;
        }

        int res[] = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i] = ans.get(i);
        }

        return res;
    }
}