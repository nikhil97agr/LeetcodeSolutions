package concatenated_words_472;

import java.util.*;
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a,b)->  b.length() - a.length());

        Set<String> set = new HashSet<>();
        for(String s : words){
            set.add(s);
        }
        List<String> result = new ArrayList<>();
        int n = words.length;
        for(String s : words){
            set.remove(s);
            Boolean dp[] = new Boolean[s.length()];
            if(check(s, 0, 0, set, s.length(), dp)){
                result.add(s);
            }
        }
        return result;
    }

    private boolean check(String s, int start, int end, Set<String> set, int n, Boolean dp[]){
        if(start == n && end ==n){
            return true;
        }

        if(end ==n) return false;

        if(dp[start] != null) return dp[start];

        boolean ans = false;

        if(set.contains(s.substring(start, end+1))){
            ans = ans || check(s, end+1, end+1, set, n, dp);
        }

        ans = ans || check(s, start, end+1, set , n ,dp);

        return dp[start] = ans;

    }
}