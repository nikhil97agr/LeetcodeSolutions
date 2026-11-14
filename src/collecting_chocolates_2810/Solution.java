package collecting_chocolates_2810;

import java.util.*;
class Solution {
    public long minCost(int[] nums, int x) {
        int n= nums.length;
        int rotation[][] = new int[n][n];
        for(int i=0;i<n;i++){
            int min = nums[i];
            for(int j=0;j<n;j++){
                int ind = (i+j)%n;
                min = Math.min(min, nums[ind]);
                rotation[i][j] = min;
            }
        }
        long sum = Arrays.stream(nums).mapToLong(y-> y).sum();
        for(int i=0;i<n;i++){
            long total = 1l * i * x;
            for(int j=0;j<n;j++){
                total += rotation[j][i];
            }

            sum = Math.min(sum, total);
        }

        return sum;
    }
}