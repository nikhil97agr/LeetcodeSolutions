package three_sum_smaller_259;

import java.util.*;
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int ind = search(nums, j+1, n-1, target - nums[i] - nums[j]);
                if(ind != -1){
                    ans += ind - j;
                }
            }
        }

        return ans;
    }

    private int search(int nums[], int start,int end, int val){
        int ind = -1;

        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] < val){
                ind = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ind;
    }
}