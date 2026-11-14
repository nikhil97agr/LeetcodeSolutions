package count_ways_to_build_rooms_in_an_ant_colony_1313;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {
    int mod = 1_000_000_007;
    List<Integer> adjList[];
    int n;
    public int waysToBuildRooms(int[] prevRoom) {
        n = prevRoom.length;
        adjList = new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int i=1;i<n;i++){
            adjList[prevRoom[i]].add(i);
        }

        Result res = dfs(0);
        int fact = 1;
        for(int i=2;i<=n;i++){
            fact = prod(fact, i);
        }
        
        return prod(fact, res.prod);
    }
    
    private Result dfs(int curr){
        int p = 1;
        int cnt = 1;
        for(int child : adjList[curr]){
            Result res = dfs(child);
            p = prod(p, res.prod);
            cnt += res.cnt;
        }
        
        p = prod(p, pow(cnt, mod - 2));
        
        return new Result(p, cnt);
    }
    
    
    private int prod(long a, long b){
        return (int)((a*b)%mod);
    }
    
    private int pow(long a, long b){
        if(a==0 || b==1)return prod(a, 1);
        if(b==0 || a==1) return 1;
        
        int p= pow(a, b/2);
        p = prod(p,p);
        if(b%2==1){
            p = prod(p,a);
        }
        
        return p;
    }
    class Result{
        int prod;
        int cnt;
        public Result(int prod, int cnt){
            this.prod = prod;
            this.cnt= cnt;
        }
    }
}