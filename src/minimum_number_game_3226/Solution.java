package minimum_number_game_3226;

import java.util.*;
class Solution {
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        Arrays.sort(nums);
        for(int i=0;i<n;i+=2){
            int first = nums[i];
            int second = nums[i+1];
            arr[i] = second;
            arr[i+1] =first;
        }
        return arr;
    }
}