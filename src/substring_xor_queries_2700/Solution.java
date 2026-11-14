package substring_xor_queries_2700;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[][] substringXorQueries(String s, int[][] queries) {
        Map<Integer, int[]> map =new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            int num = 0;
            for(int j=i;j < Math.min(n, i+30);j++){
                num <<= 1;
                int dig = s.charAt(j) - '0';
                num |= dig;
                final int i1=  i;
                final int j1 = j;
                map.compute(num, (key, value)->{
                    if(value == null){
                        return new int[]{i1, j1};
                    }
                    
                    int len1 = value[1] - value[0] + 1;
                    int len2 = j1 - i1 + 1;
                    
                    if(len2 < len1){
                        return new int[]{i1, j1};
                    }
                    
                    return value;
                    
                });
            }
        }
        
        int ans[][] = new int[queries.length][2];
        for(int i=0;i<queries.length;i++){
            int first = queries[i][0];
            int second = queries[i][1];
            int xor = (first ^ second);
            if(!map.containsKey(xor)){
                ans[i] = new int[]{-1,-1};
            }else{
                ans[i] = map.get(xor);
            }
        }
        return ans;
    }
}