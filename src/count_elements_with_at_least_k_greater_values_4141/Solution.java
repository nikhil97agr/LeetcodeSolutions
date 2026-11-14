package count_elements_with_at_least_k_greater_values_4141;

import java.util.*;
class Solution {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        if(k==0) return nums.length;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int ind = find(nums, i+1, nums[i]);
            if(ind == -1) continue;
            if(n - ind >=k){
                ans++;
            }
        }

        return ans;
    }

    private int find(int nums[], int start, int val){
        int end = nums.length - 1;

        int ind = -1;
        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] > val){
                ind = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ind;
    }
}