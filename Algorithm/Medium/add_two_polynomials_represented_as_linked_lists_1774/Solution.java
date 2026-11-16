package add_two_polynomials_represented_as_linked_lists_1774;

import java.util.*;
// Definition for polynomial singly-linked list.
class PolyNode {
    int coefficient, power;
    PolyNode next = null;

    PolyNode() {}
    PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
    PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
}

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        while(poly1 != null){
            int key = poly1.coefficient;
            int pow = poly1.power;
            map.merge(pow, key, Integer::sum);
            poly1 = poly1.next;
        }

        while(poly2 != null){
            int key = poly2.coefficient;
            int pow = poly2.power;
            map.merge(pow, key, Integer::sum);
            poly2 = poly2.next;
        }
        PolyNode result = new PolyNode();
        PolyNode curr= result;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() ==0) continue;
            PolyNode node = new PolyNode(entry.getValue(), entry.getKey());
            result.next = node;
            result = result.next;
        }

        return curr.next;
    }
}