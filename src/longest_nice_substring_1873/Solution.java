package longest_nice_substring_1873;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        new Solution().longestNiceSubstring("YazaAay");
    }
    public String longestNiceSubstring(String s) {
        String res = "";
        Map<Character, Integer> map = new HashMap<>();

        for(int i=1;i<=s.length();i++){
            int start = 0;
            int end = 0;
            map.clear();
            while(end < i){
                map.merge(s.charAt(end), 1, Integer::sum);
                end++;
            }

            if(check(map)){
                res = s.substring(start, end);
                continue;
            }

            while(end < s.length()){
                map.merge(s.charAt(start), -1, Integer::sum);
                map.merge(s.charAt(end), 1, Integer::sum);
                start++;
                end++;
                if(check(map)){
                    res = s.substring(start, end);
                    break;
                }
            }
        }

        return res;
    }

    private boolean check(Map<Character, Integer> map){
        for(char c1 = 'a',c2='A';c1<='z';c1++,c2++){
            int cn1 = map.getOrDefault(c1, 0);
            int cn2 = map.getOrDefault(c2, 0);
            if((cn1==0 && cn2>0) || (cn1 > 0 && cn2 == 0)){
                return false;
            }
        }
        return true;
    }


}