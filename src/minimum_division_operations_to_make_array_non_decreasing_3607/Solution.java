package minimum_division_operations_to_make_array_non_decreasing_3607;

import java.util.*;
import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        boolean prime[] = new boolean[max+1];
        Arrays.fill(prime, true);
        
        seive(prime);
        
        int ans = 0;
        
        
        for(int i=n-1;i>0;i--){
            if(nums[i] >= nums[i-1]) continue;
            
            if(prime[nums[i-1]]) return -1;
            

            while(!prime[nums[i-1]] && nums[i-1] > 1){
                int div = getDiv(nums[i-1]);
                nums[i-1] /= div;
                ans++;
                
            }
            
            if(nums[i-1] > nums[i]) return -1;
            
            
        }
        return ans;
    }
    
    private int getDiv(int x){
        
        if(x%2==0){
            return x/2;
        }
        
        for(int i=3;i<=Math.sqrt(x);i+=2){
            if(x%i==0){
                return x/i;
            }
        }
        
        return 1;
    }
    
    private void seive(boolean prime[]){
        prime[0] = prime[1] = false;

        
        int i=4;
        
        while(i < prime.length){
            prime[i] = false;
            i+=2;
        }
        
        for( i=3;i<prime.length;i+=2){
            if(prime[i]){
                int j=i+i;
                
                while( j < prime.length){
                    prime[j] = false;
                    j+=i;
                }
            }
        }
    }
}