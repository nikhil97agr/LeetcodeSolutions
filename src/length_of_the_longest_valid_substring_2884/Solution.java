package length_of_the_longest_valid_substring_2884;

import java.util.*;
class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int ans = 0;
        var set = new HashSet<String>();
        for(var s : forbidden){
            set.add(s);
        }
        var n = word.length();
        int end = 0;
        int start = 0;
        while(end < n){
            for(int i = end;i> end- 10 && i >= start;i--){
                var sub = word.substring(i, end + 1);
                if(set.contains(sub)){
                    start = i + 1;
                    break;
                }
            }
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }
}