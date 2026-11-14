package maximum_sum_of_three_numbers_divisible_by_three_4160;

import java.util.*;
class Solution {
    public int maximumSum(int[] nums) {
        Arrays.sort(nums);
        int zero[] = sum(0, nums);
        int one[] = sum(1, nums);
        int two[] = sum(2, nums);

        int ans= max(
            zero[2],
            one[2],
            two[2]

        );

        if(one[0] !=0 && two[0] !=0 && zero[0] !=0){
            ans = Math.max(ans, one[0] + two[0] + zero[0]);
        }

        return ans;

    }

    private int max(int...arr){
        int res = 0;
        for(int x : arr){
            res = Math.max(res, x);
        }

        return res;
    }

    private int[] sum(int mod, int []nums){
        int res[] = new int[3];
        int ind = 0;
        int sum =0;
        for(int i=nums.length-1;ind < 3 && i>=0;i--){
            if(nums[i]%3 == mod){
                sum += nums[i];
                res[ind] = sum;
                ind++;
            }
        }
        return res;
    }
}