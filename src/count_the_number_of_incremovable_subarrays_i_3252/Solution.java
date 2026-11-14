package count_the_number_of_incremovable_subarrays_i_3252;

import java.util.*;
class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                List<Integer> list = new ArrayList<>();
                for(int k=0;k<n;k++){
                    if(k <i || k>j){
                        list.add(nums[k]);
                    }
                }
                boolean result = true;
                for(int k=0;k<list.size()-1;k++){
                    if(list.get(k) >= list.get(k+1)){
                        result = false;
                        break;
                    }
                }
                if( result) ans++;
            }
            
            
            
        }
        
        return ans;
    }
}