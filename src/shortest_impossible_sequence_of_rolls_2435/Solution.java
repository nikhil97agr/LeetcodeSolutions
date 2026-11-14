package shortest_impossible_sequence_of_rolls_2435;

import java.util.*;
class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int next= 1;
        Set<Integer> set = new HashSet<>();
        int n = rolls.length;
        for(int i=0;i<n;i++){
            set.add(rolls[i]);

            if(set.size() == k){
                next++;
                set.clear();
            }
        }

        return next;
    }
}