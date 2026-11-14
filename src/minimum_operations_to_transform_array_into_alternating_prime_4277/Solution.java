package minimum_operations_to_transform_array_into_alternating_prime_4277;

import java.util.*;
class Solution {
    public int minOperations(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int last = max + 100;
        boolean primes[] = new boolean[last + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for(int i=1;i<=last;i++){
            if(primes[i]){
                int j = i << 1;
                for(;j<=last;j+=i){
                    primes[j] = false;
                }
            }
        }

        TreeSet<Integer> set = new TreeSet<>();
        for(int i=2;i<primes.length;i++){
            if(primes[i]) set.add(i);
        }
        int ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i+=2){
            if(!set.contains(nums[i])){
                int next = set.higher(nums[i]);
                ans += Math.abs(next - nums[i]);
            }
        }
        for(int i=1;i<n;i+=2){
            if(nums[i] == 2){
                ans += 2;
                continue;
            }
            if(nums[i] == 3){
                ans += 1;
                continue;
            }

            if(set.contains(nums[i])){
                ans++;
            }
        }

        return ans;
    }
}