package k_radius_subarray_averages_2211;

import java.util.*;
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int result[] = new int[n];

        if(k==0){
            return nums;
        }
        Arrays.fill(result, -1);
        long left[] = new long[n];
        long right[] = new long[n];
        long total = 0;
        for(int i=0;i<Math.min(n,k);i++){
            total += nums[i];
        }
        int j=0;
        for(int i=k;i<n;i++){
            
            left[i] =total;
            total -= nums[j++];
            total += nums[i];
        }
        j = n-1;
        total = 0;
        for(int i=n-1;i>=Math.max(n-k,0);i--){
            total += nums[i];
        }
        for(int i=n-k-1;i>=0;i--){
            right[i] = total;
            total -= nums[j--];
            total += nums[i];
        }

        for(int i=k;i<n-k;i++){
            result[i] =(int) ((left[i]+right[i] + nums[i])/(2*k+1));
        }
        return result;
    }
}