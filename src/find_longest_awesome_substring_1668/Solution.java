package find_longest_awesome_substring_1668;

import java.util.*;
class Solution {
    public int longestAwesome(String s) {
        int ans = 0;
        int n = s.length();
        int bits = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            int ind = c- '0';

            bits ^= (1<<ind);

            if(bits == 0 || (bits & (bits-1)) == 0){
                ans = Math.max(ans, i + 1);
            }else{
                for(int j=0;j<10;j++){
                    if( (bits & (1<<j)) != 0){
                        int req = bits ^ (1<<j);
                        if(map.containsKey(req)){
                            ans = Math.max(ans, i - map.get(req));
                        }
                    }else{
                        int req = bits | (1<<j);
                        if(map.containsKey(req)){
                            ans = Math.max(ans, i - map.get(req));
                        }
                    }
                }
            }

            if(!map.containsKey(bits)){
                map.put(bits, i);
            }

        }
        return ans;
    }
}