package split_array_by_prime_indices_3936;

import java.util.*;
import java.util.Arrays;

class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length;
        boolean prime[] = new boolean[n];

        Arrays.fill(prime, true);
        if(n==1){
            return nums[0];
        }
        prime[0] = prime[1] = false;

        for(int i=2;i<n;i++){
            if(prime[i]){
                int j = i+i;

                while(j < n){
                    prime[j] = false;
                    j+=i;
                }
            }
        }

        long ans = 0;

        for(int i=0;i<n;i++){
            if(prime[i]){
                ans += 1l*nums[i];
            }else{
                ans -= 1l*nums[i];
            }
        }

        return Math.abs(ans);
    }
}