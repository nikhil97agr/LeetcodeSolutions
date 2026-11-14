package valid_triangle_number_611;

import java.util.*;
class Solution {
    public int triangleNumber(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int ind = bs(nums, nums[i] + nums[j], j+1, n-1);
                if(ind != -1)
                ans +=(ind - j);
            }
        }

        return ans;
    }

    private int bs(int nums[], int value, int start, int end){
        int ind = -1;
        while(start <= end){
            int mid = (start+end)/2;

            if(nums[mid] < value){
                ind = mid;
                start = mid+1;
            }else{

                end = mid-1;
            }
        }
      return ind;

    }
}