package minimum_impossible_or_2705;

import java.util.*;
class Solution {
    public int minImpossibleOR(int[] nums) {
        Arrays.sort(nums);
        if(nums[0]!=1){
            return 1;
        }
        
        int n = nums.length;
        if(n==1){
            return 2;   
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int x : nums){
            set.add(x);
        }
        
        int max_pow = (int)Math.ceil(Math.log(nums[n-1])/Math.log(2));
        for(int i=0;i<=max_pow;i++){
            if(!set.contains(1<<i)){
                return 1<<i;
            }
        }
        
        return 1<<(max_pow+1);
    }
}