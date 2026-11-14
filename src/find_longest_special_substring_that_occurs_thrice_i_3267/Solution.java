package find_longest_special_substring_that_occurs_thrice_i_3267;

import java.util.*;
class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int count = 0;
        int ans = -1;
        Map<String, Integer> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            count = 0;
            int j=0;
            int k=i;
            while(k<=n){
                String s2 = s.substring(j,k);
                map.put(s2, map.getOrDefault(s2, 0)+1);
                j++;
                k++;
            }
            
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue()>=3){
                boolean result = true;
                char c = entry.getKey().charAt(0);
                for(char ch : entry.getKey().toCharArray()){
                    if(c!=ch){
                        result = false;
                        break;
                    }
                }
                if(result)
                ans = Math.max(ans, entry.getKey().length());
            } 
                
        }
        return ans;
    }
}