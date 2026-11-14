package unit_conversion_i_3729;

import java.util.*;
class Solution {
            long mod = (long)1e9 + 7;

    public int[] baseUnitConversions(int[][] conversions) {
        int n = conversions.length + 1;
        long ans[] = new long[n];
        ans[0] = 1;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int degree[] = new int[n];
        for(int c[] : conversions){
            map.computeIfAbsent(c[0], x-> new HashMap<>()).put(c[1], c[2]);
            degree[c[1]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        que.offer(0);

        while(!que.isEmpty()){
            int node = que.poll();
            long cnt = ans[node];

            for(Map.Entry<Integer, Integer> entry : map.getOrDefault(node, new HashMap<>()).entrySet()){
                int x = entry.getKey();
                int y = entry.getValue();
                ans[x] = add(ans[x], cnt*y);
                degree[x]--;

                if(degree[x] == 0){
                    que.offer(x);
                }
            }
        }

        int res[] = new int[n];
        for(int i=0;i<n;i++){
            res[i] = (int)ans[i];
        }

        return res;

        

        

        
    }

    private long add(long a, long b){
        return ((a%mod)+(b%mod))%mod;
    }
}