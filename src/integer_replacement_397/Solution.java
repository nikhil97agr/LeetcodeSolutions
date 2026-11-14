package integer_replacement_397;

import java.util.*;
class Solution {
    public int integerReplacement(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        if(n==1) return 0;
        if((n&(n-1))==0){
            return (int)(Math.log(n)/Math.log(2));
        }

        if( n == ((1<<31)-1)) return 32;
        
        return solve(n, map);
    }

    private int solve(int n, Map<Integer, Integer> map){
        if(n==1) return 0;

        if(map.containsKey(n)) return map.get(n);
        int ans = 0;
        if((n&1)==1){
            ans = 1 + Math.min(solve(n-1, map), solve(n+1, map));
        }else{
            ans = 1 + solve(n/2, map);
        }

        map.put(n, ans);
        return ans;
    }
}