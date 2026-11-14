package convert_doubly_linked_list_to_array_ii_3615;

import java.util.*;
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};

class Solution {
    public int[] toArray(Node node) {
        List<Integer> list = new ArrayList<>();

        Deque<Integer> que = new ArrayDeque<>();

        Node prev = node.prev;

        while(node != null){
            que.offerLast(node.val);
            node = node.next;
        }
        while(prev != null){
            que.offerFirst(prev.val);
            prev = prev.prev;
        }

        int ans[]= new int[que.size()];

        int i=0;
        while(!que.isEmpty()){
            ans[i++] = que.pollFirst();
        }
        return ans;
    }
}