package count_the_number_of_fair_pairs_2699;

import java.util.*;
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans  = 0;
        int n = nums.length;
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            int low = lower - nums[i];
            int high = upper - nums[i];
            ans += bs(high, low, i+1, n-1, nums);
        }
        return ans;
    }

    private long bs(int high, int low, int start, int end, int nums[]){
        int s = start;
        int e = end;
        int i= -1;
        int j = -1;

        while(s <= e){
            int mid = (s+e)/2;
            if(nums[mid] >= low){
                i = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }

        s = start;
         e = end;
         while(s <= e){
            int mid = (s+e)/2;
            if(nums[mid] <= high){
                j = mid;
                 s = mid+1;
            }else{
                e = mid-1;
            }
         }

         if( i== -1 || j == -1){
            return 0;
         }

         return j-i+1;
    }
}