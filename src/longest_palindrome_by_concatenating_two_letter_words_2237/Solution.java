package longest_palindrome_by_concatenating_two_letter_words_2237;

import java.util.*;
class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        boolean repeat = false;
        int count = 0;
        int repeatCount = 0;
        for(String word : words){
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            String reverse = sb.toString();
            
            if(map.containsKey(reverse)){
                if(reverse.equals(word)){
                    repeatCount-=1;
                }
                count += 4;
                if(map.get(reverse)==1){
                    map.remove(reverse);
                }
                else{
                    map.put(reverse, map.get(reverse)-1);
                }
                continue;
            }
            if(reverse.equals(word)){
                repeatCount += 1;
            }
            map.put(word, map.getOrDefault(word,0)+1);
        }
        if(repeatCount>0){
            count+=2;
        }
        return count;


        
    }
}