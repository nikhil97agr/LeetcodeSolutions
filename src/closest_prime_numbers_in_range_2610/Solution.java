package closest_prime_numbers_in_range_2610;

import java.util.*;
class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean primes[] = new boolean[right+1];

        Arrays.fill(primes, true);

        primes[0] = primes[1]= false;

        for(int i=2;i<=right;i++){
            if(primes[i])
            for(int j=i+i;j<=right;j+=i){
                primes[j] = false;
            }
        }

        List<Integer> res = new ArrayList<>();
        while(left <= right){
            if(primes[left]){
                res.add(left);
            }
            left++;
        }
        if(res.size() <2){
            return new int[]{-1, -1};
        }
        int diff = Integer.MAX_VALUE;
        int ans[] = new int[2];
        for(int i=1;i<res.size();i++){
            int a = res.get(i);
            int b = res.get(i-1);
            if(a-b < diff){
                diff = a-b;
                ans[0] = b;
                ans[1] = a;

            }
        }
        return ans;
    }
}