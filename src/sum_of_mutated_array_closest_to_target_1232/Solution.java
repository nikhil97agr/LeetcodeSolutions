package sum_of_mutated_array_closest_to_target_1232;

import java.util.*;
class Solution {
    public int findBestValue(int[] arr, int target) {
        int ans = Integer.MAX_VALUE;

        int prev = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int min = 0;
        int max = arr[arr.length - 1];

        while(min <= max){
            int sum = 0;
            int mid = (min + max)/2;
            for(int x : arr){
                sum += Math.min(x, mid);
            }

            int diff = Math.abs(sum - target);

            if(diff < prev || (diff == prev && mid < ans)){
                prev = diff;
                ans= mid;
            }
            if(sum < target){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }

        return ans;
    }
}