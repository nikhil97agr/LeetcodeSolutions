import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<Integer> adjList[];
    int vals[];
    int n;
    long scores[];
    long mod = (long) 1e9 + 7;
    int max = (1<<10);
    public int goodSubtreeSum(int[] vals, int[] par) {
        n = vals.length;
        scores = new long[n];
        this.vals = vals;
        adjList = new ArrayList[n];
        for(int i=0;i<n;i++) adjList[i] = new ArrayList<>();
        for(int i=1;i<n;i++){
            adjList[par[i]].add(i);
        }
        dfs(0);

        int res = 0;
        for(long x :scores) res = add(res, x);
         return res;
    }

    private long[] dfs(int curr){
        long maskScore[] = new long[max];
        Arrays.fill(maskScore, -1);
        maskScore[0] = 0;
        long ans = 0;
        int mask = convertToMask(vals[curr]);
        if(mask != -1){
            maskScore[mask] = vals[curr];
            ans = vals[curr];
        }

        for(int child : adjList[curr]){
            long childScore[] = dfs(child);
            for(int i=0;i<max;i++){
                if(maskScore[i] == -1) continue;
                for(int j=0;j<max;j++){
                    if(childScore[j]==-1) continue;

                    if((i & j) !=0) continue;

                     mask = (i | j);
                     maskScore[mask] = Math.max(maskScore[mask], maskScore[i] + childScore[j]);
                     ans = Math.max(ans, maskScore[mask]);
                }
            }
        }
        scores[curr] = ans;

        return maskScore;


    }

    private int convertToMask(int n){
        int mask = 0;
        while(n > 0){
            int digit = n%10;
            n/=10;
            if((mask & (1<<digit))!=0) return -1;
            mask |= (1<<digit);
        }

        return mask;
    }


    private int add(long a, long b){
        return (int)((a+b)%mod);
    }

}