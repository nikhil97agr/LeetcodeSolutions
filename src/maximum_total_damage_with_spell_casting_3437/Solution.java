package maximum_total_damage_with_spell_casting_3437;

import java.util.*;
class Solution {
    public long maximumTotalDamage(int[] power) {
        long ans = 0;
        Map<Long, Long> map = new HashMap<>();
        for(int x : power){
            map.put(1L*x, map.getOrDefault(1L*x, 0L)+1);
        }
        Long dp[] = new Long[map.size()];
        List<Long> p = new ArrayList<>(map.keySet());
        Collections.sort(p);
        return solve(0, p.size(), p, map, dp);
    }
    
    private long solve(int i, int n, List<Long> p, Map<Long, Long> map, Long dp[]){
        
        if(i>=n) return 0;
        
        if(dp[i]!=null){
             return dp[i];
        }
        long ans = 0;
        long curr = p.get(i)*map.get(p.get(i));
        long power = p.get(i);
        if(i+1 < n && p.get(i+1) > power+2){
            ans = curr + solve(i+1, n, p, map, dp);            
        }else if(i+2 < n && p.get(i+2) > power + 2){
            ans = Math.max(curr + solve(i+2, n, p, map, dp), solve(i+1, n, p, map, dp));
        }else{
            ans = Math.max(
                curr + solve(i+3, n, p, map, dp),
                solve(i+1, n, p, map, dp)
            );
        }
        
        return dp[i] = ans;
    }
}