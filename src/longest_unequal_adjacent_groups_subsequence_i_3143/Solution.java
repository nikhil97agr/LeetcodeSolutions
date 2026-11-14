package longest_unequal_adjacent_groups_subsequence_i_3143;

import java.util.*;
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> l1 = new ArrayList<>();
        l1.add(words[0]);
        int curr = groups[0];

        for(int i=1;i<words.length;i++){
            if(groups[i] != curr){
                l1.add(words[i]);
                curr = groups[i];
            }
        }
        return l1;
    }
}