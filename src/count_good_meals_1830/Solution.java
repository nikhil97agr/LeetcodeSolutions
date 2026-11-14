package count_good_meals_1830;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public int countPairs(int[] arr) {
        Map<Long, Long> map = new HashMap<>();
        long mod = (long)1e9 + 7;

        for(long x : arr) map.merge(x, 1l , Long::sum);
        long ans = 0;
        Set<Long> set = new HashSet<>(map.keySet());
        for(long key : set){
            for(long i=1 ; i<= (1<<21);i<<=1){
                if(key <= i){
                    long req = i - key;
                    if(req == key){
                        long cnt = map.get(key);
                        long val = (cnt*(cnt-1))/2;
                        ans = add(ans, val, mod);
                    }else{
                        long cnt = map.getOrDefault(req, 0l);
                        long total = cnt*map.get(key);
                        ans = add(ans, total, mod);
                    }
                }
            }
            map.remove(key);
        }
        return (int)ans;
    }

    private long add(long a, long b, long mod){
        return (a%mod + b%mod)%mod;
    }
}