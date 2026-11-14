package can_i_win_464;

import java.util.*;
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal == 0) return true;
        int maxSum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if(maxSum < desiredTotal) return false;

        Map<Integer, Boolean> map =new HashMap<>();
        boolean vis[] = new boolean[maxChoosableInteger+1];

        return solve(desiredTotal, map, vis);
    }

    private boolean solve(int n, Map<Integer, Boolean> map, boolean vis[]){
        if(n <=0) return false;

        int key = key(vis);
        if(map.containsKey(key)) return map.get(key);

        for(int i=1;i< vis.length;i++){
            if(!vis[i]){
                vis[i] =true;
                if(!solve(n-i, map, vis)){
                    vis[i] = false;
                    map.put(key, true);
                    return true;
                }
                vis[i] = false;
            }
        }

        map.put(key, false);
        return false;
    }

    private int key(boolean vis[]){
        int key = 0;
        for(boolean b : vis){
            key <<= 1;
            if(b){
                key |= 1;
            }
        }
        return key;
    }
}