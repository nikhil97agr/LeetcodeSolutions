package number_of_ways_to_paint_sheets_4132;

import java.util.*;
class Solution {
    long mod = (long)1e9 + 7;
    public int numberOfWays(int n, int[] limit) {
        int len = limit.length;
        for(int i=0;i<len;i++){
            limit[i] = Math.min(limit[i], n-1);
        }

        Arrays.sort(limit);

        int ans = 0;
        long suff[] = new long[len+1];
        for(int i=len-1;i>=0;i--){
            suff[i] = suff[i+1] + limit[i];
        }
        int y =0;

        for(int  x = len - 1;x>=0 && limit[x] + limit[len - 1] >= n;x--){
            while(limit[x] + limit[y] < n)y++;

            if(x >=y){
                ans = add(ans, add(suff[y] - limit[x], -prod(n-limit[x]-1, len-y-1)));
            }else{
                ans = add(ans, add(suff[y], -prod(n - limit[x] - 1, len - y)));
            }
        }

        return ans;

    }

    private int prod(long a, long b){
        return (int)((a*b)%mod);
    }

    private int add(long a, long b){
        long sum = a+ b + mod;
        return (int)(sum%mod);
    }
}