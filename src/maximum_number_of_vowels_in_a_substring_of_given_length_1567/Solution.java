package maximum_number_of_vowels_in_a_substring_of_given_length_1567;

import java.util.*;
class Solution {
    public int maxVowels(String s, int k) {
        int cnt[] = new int[26];
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count = 0;
        int n =s.length();
        for(int i=0;i<k;i++){
            if(set.contains(s.charAt(i))){
                count++;
            }
        }
        int max = count;
        int start = 0;
        int end = k;
        while(end<n){
            if(set.contains(s.charAt(start))){
                count--;
            }
            if(set.contains(s.charAt(end))){
                count++;
            }
            max = Math.max(count, max);
            start++;
            end++;
        }
        return max;
    }
}