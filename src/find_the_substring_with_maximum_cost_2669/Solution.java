package find_the_substring_with_maximum_cost_2669;

import java.util.*;
class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int score[] = new int[26];
        Arrays.fill(score, Integer.MAX_VALUE);
        for(int i=0;i<chars.length();i++){
            score[chars.charAt(i)-'a'] = vals[i];
        }
        
        for(int i=0;i<26;i++){
            if(score[i] == Integer.MAX_VALUE){
                score[i] = i+1;
            }
            
            
        }
        
        int total = Integer.MIN_VALUE;
        int cnt = 0;
        for(char c : s.toCharArray()){
            cnt += score[c-'a'];
            if(total < cnt){
                total = cnt;
            }
            if(cnt<0){
                cnt = 0;
            }
        }
        
        return Math.max(total, 0);
        
    }
}