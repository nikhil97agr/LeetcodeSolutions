package divide_array_into_arrays_with_max_difference_3241;

import java.util.*;
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans[][] = new int[n/3][3];
        int j=0;
        for(int i=0;i<n;i+=3){
            int a = nums[i];
            int b = nums[i+1];
            int c = nums[i+2];

            if(c-a > k) return new int[0][];

            ans[j++] = new int[]{a,b,c};
        }

        return ans;
    }
}