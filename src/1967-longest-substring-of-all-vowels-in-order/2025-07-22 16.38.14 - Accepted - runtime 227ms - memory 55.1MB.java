import java.util.*;

class Solution {
    public int longestBeautifulSubstring(String word) {
        TreeMap<Character, Integer> set = new TreeMap();
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e','i','o','u'));
        int ans =0 ;
        int start =0;
        int end = 0;
        int n =word.length();
        while ( end < n){
            char c = word.charAt(end);
            if(vowel.contains(c)) {
                set.merge(c, 1, Integer::sum);

                while(start < end && set.higherKey(c)!=null){
                    char ch = word.charAt(start);
                    if(vowel.contains(ch)){
                        set.merge(ch, -1, Integer::sum);
                        if(set.get(ch) ==0) set.remove(ch);
                    }
                    start++;
                }
            }
            if(set.size() == 5){
                ans = Math.max(ans, end - start+1);
            }
            end++;



        }
        
        return ans;
    }
}