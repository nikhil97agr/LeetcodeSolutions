package sum_of_gcd_of_formed_pairs_4242;

import java.util.*;
class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        long gcd[] = new long[n];
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, nums[i]);
            gcd[i] = gcd(max, nums[i]);
        }

        Arrays.sort(gcd);
        long ans = 0;
        int start =0;
        int end = n-1;
        while(start < end){
            ans += gcd(gcd[start], gcd[end]);
            start++;
            end--;
        }

        return ans;
    }

    private long gcd(long a, long b){
        if(a==0) return b;
        return gcd(b%a, a);
    }
}