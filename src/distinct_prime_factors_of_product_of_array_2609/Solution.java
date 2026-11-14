package distinct_prime_factors_of_product_of_array_2609;

import java.util.*;
class Solution {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        for(int x : nums){
            check(x, set);
        }
        return set.size();
    }
    
    private void check(int x, Set<Integer>set){
        while(x%2==0){
            x/=2;
            set.add(2);
            
        }
        
        for(int i=3;i<=Math.sqrt(x);i+=2){
            if(x%i==0){
                set.add(i);
                while(x%i==0){
                    x/=i;
                }
            }
        }
        if(x>1){
            set.add(x);
        }
        
    }
}