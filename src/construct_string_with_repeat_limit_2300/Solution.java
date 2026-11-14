package construct_string_with_repeat_limit_2300;

import java.util.*;
class Solution {
    public String repeatLimitedString(String s, int limit) {
        TreeMap<Character, Integer> map = new TreeMap<>();

        for(char c : s.toCharArray()){
            int cnt = map.getOrDefault(c, 0);
            map.put(c, cnt+1);
        }
        StringBuilder res = new StringBuilder();
        while(!map.isEmpty()){
            char high = map.lastKey();
            int cnt = map.get(high);

            if(cnt <= limit){
                while(cnt > 0){
                    res.append(high);
                    cnt--;
                }
                map.remove(high);
            }else{
                int left = limit;
                while(left > 0){
                    left--;
                    res.append(high);
                }
                map.put(high, cnt - limit);

                Character c = map.lowerKey(high);
                if(c==null) return res.toString();
                res.append(c);
                cnt = map.get(c);
                if(cnt ==1) map.remove(c);
                else map.put(c, cnt - 1);
            }
        }

        return res.toString();
    }
}