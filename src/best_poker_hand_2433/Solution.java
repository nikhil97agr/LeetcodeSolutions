package best_poker_hand_2433;

import java.util.*;
class Solution {
    public String bestHand(int[] r, char[] s) {
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for(int x : r) m1.put(x, m1.getOrDefault(x, 0)+1);
        for(char c : s) m2.put(c, m2.getOrDefault(c, 0)+1);

        Set<Integer> rank = new HashSet<>(m1.values());
        Set<Integer> suit = new HashSet<>(m2.values());

        if(suit.contains(5)) return "Flush";
        if(rank.contains(3) || rank.contains(4)) return "Three of a Kind";
        if(rank.contains(2)) return "Pair";
        return "High Card";
    }
}