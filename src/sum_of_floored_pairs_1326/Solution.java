package sum_of_floored_pairs_1326;

import java.util.*;
class Solution {
    public int sumOfFlooredPairs(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        int cnt[] = new int[max + 1];
        for(int x : nums) cnt[x]++;

        int pre[] = new int[max + 1];
        pre[0] = cnt[0];
        for(int i=1;i<=max;i++) pre[i] = pre[i-1] + cnt[i];

        for(int i=1;i<=max;i++){
            if(cnt[i] == 0) continue;
            for(int j=i;j<=max;j+=i){
                int start = j;
                int end = Math.min(max, j + i - 1);

                int c = pre[end] - pre[start-1];
                ans = add(ans, prod(j/i, prod(c, cnt[i])));
            }
        }

        return ans;
    }

    private int prod(long a, long b){
        long mod =(long)1e9 + 7;
        long p = a * b;

        return (int)(p %mod);
    }
    private int add(long a, long b){
        long sum = a + b;
        long mod =(long)1e9 + 7;

        return (int)(sum%mod);
    }

}