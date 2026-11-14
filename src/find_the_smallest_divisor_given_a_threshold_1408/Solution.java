package find_the_smallest_divisor_given_a_threshold_1408;

import java.util.*;
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        while(min <= max){
            int mid = (min+max)/2;
            int sum = 0;
            for(int x : nums){
                if(x%mid==0){
                    sum += x/mid;
                }else{
                    sum += x/mid + 1;
                }
            }
            if(sum <= threshold){
                ans = mid;
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return ans;
    }
}