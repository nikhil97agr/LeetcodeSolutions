package domino_and_tromino_tiling_806;

import java.util.*;
class Solution {
    int mod = (int)1e9 + 7;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int numTilings(int n) {
        if(map.containsKey(n)){
            return map.get(n)%mod;
        }
        if(n==1 || n==0){
            return 1;
        }
        if(n==2) return 2;

        map.put(n,((numTilings(n-1)*2)%mod + numTilings(n-3)%mod)%mod);
        return map.get(n);
    }

   
}