package shortest_word_distance_iii_245;

import java.util.*;
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        TreeSet<Integer> t1 = new TreeSet<>();
        TreeSet<Integer> t2 = new TreeSet<>();
        for(int i=0;i<wordsDict.length;i++){
            if(wordsDict[i].equals(word1)) t1.add(i);
            if(wordsDict[i].equals(word2)) t2.add(i);
        }
        int ans = 100000;
        for(int ind : t1){
            Integer higher = t2.higher(ind);
            Integer lower = t2.lower(ind);

            if(higher != null){
                ans = Math.min(ans, Math.abs(higher - ind));
            }

            if(lower != null){
                ans = Math.min(ans, Math.abs(lower - ind));
            }
        }

        return ans;
    }
}