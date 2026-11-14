package word_break_ii_140;

import java.util.*;
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<String>();
        int n = s.length();
        HashSet<String> set = new HashSet();
        for(String x : wordDict){
            set.add(x);
        }
        solve(s, set, "", 0, 0, result, n);
        return result;
    }
    
    
    public void solve(String s, HashSet<String> set, String ans, int start, int end, List<String> result, int n){
        if(start==n&&end==n){
            result.add(ans.trim());
        }
        if(end==n){
            return;
        }
        
        if(set.contains(s.substring(start, end+1))){
            solve(s, set, ans+s.substring(start, end+1)+" ",  end+1, end+1, result, n);
        }
            solve(s, set, ans, start, end+1, result, n);

        return;
    }
}