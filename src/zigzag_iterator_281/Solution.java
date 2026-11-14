package zigzag_iterator_281;

import java.util.*;
class ZigzagIterator {
    List<Integer> l1;
    List<Integer> l2;
    int i=0;
    int j=0;
    int turn = 0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
       l1 = v1;
       l2 = v2; 
    }

    public int next() {
        if(turn == 0){
            turn = 1;
            if( i < l1.size()){
                i++;
                return l1.get(i-1);
            }else{
                j++;
                return l2.get(j-1);
            }
        }else{
            turn = 0;
            if(j < l2.size()){
                j++;
                return l2.get(j-1);
            }else{
                i++;
                return l1.get(i-1);
            }
        }
    }

    public boolean hasNext() {
        return i < l1.size() || j < l2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */