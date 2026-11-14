package check_if_all_characters_have_equal_number_of_occurrences_2053;

import java.util.*;
class Solution {
    public boolean areOccurrencesEqual(String s) {
        int cnt[] =new int[26];
        for(char c: s.toCharArray()){
            cnt[c-'a']++;
        }

        Set<Integer> set = new HashSet<>();
        for(int x : cnt){
            if(x!=0) set.add(x);
        }

        return set.size() == 1;
    }
}