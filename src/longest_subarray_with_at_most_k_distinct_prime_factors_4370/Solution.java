package longest_subarray_with_at_most_k_distinct_prime_factors_4370;

import java.util.*;
class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();

        boolean primes[] = new boolean[max + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        List<Integer> prime = new ArrayList<>();
        for(int i=2;i<=max;i++){
            if(primes[i]){
                prime.add(i);
                int j = i + i;
                while(j <= max){
                    primes[j] = false;
                    j+=i;
                }
            }
        }


        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(calc(nums[i], prime));
        }

        int cnt[] = new int[max + 1];
        int ans =0 ;
        int dist = 0;
        int l = 0;
        int r = 0;
        do{

            for(var p : list.get(r)){
                cnt[p]++;
                if(cnt[p] == 1) dist++;
            }

            while(dist > k && l <= r){
                for(var p : list.get(l)){
                    cnt[p]--;
                    if(cnt[p] == 0){
                        dist--;
                    }
                }
                l++;
            }

            ans = Math.max(ans, r - l + 1);
            r++;
        }while(r < n);


        return ans;
        
    }

    private Set<Integer> calc(int n, List<Integer> primes){
        Set<Integer> set = new HashSet<>();
        for(int x : primes){
            if( 1l*x*x > n) break;
            if(n%x==0){
                set.add(x);
                while(n%x==0){
                    n/=x;
                }
            }
        }

        if( n > 1){
            set.add(n);
        }
        return set;
    }


}