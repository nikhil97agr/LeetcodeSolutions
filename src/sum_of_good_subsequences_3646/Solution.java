package sum_of_good_subsequences_3646;

import java.util.*;
class Solution {
    int mod = 1_000_000_007;
    public int sumOfGoodSubsequences(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int cntSeq[] = new int[max + 3];
        int seqSum[] = new int[max + 3];
        int ans = 0;
        for(int x : nums){
            int val = x;
            x = x + 1; //shift for zero index
            int prevCnt = add(cntSeq[x-1], cntSeq[x+1] + 1);
            cntSeq[x] = add(prevCnt, cntSeq[x]);
            
            seqSum[x] = add(seqSum[x] , seqSum[x-1], seqSum[x+1]);
            seqSum[x] = add(seqSum[x], prod(prevCnt, val));
        }

        for(int x : seqSum){
            ans = add(ans, x);
        }

        return ans;
    }

    private int add(long...arr){
        long total = 0;
        for(long x : arr){
            total += x;
            total %=mod;
        }

        return (int)total;
    }

    private int prod(long...arr){
        long total = 1;
        for(long x : arr){
            total *= x;
            total%=mod;
        }

        return (int)total;
    }
}