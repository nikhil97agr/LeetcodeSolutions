package count_the_number_of_square_free_subsets_2709;

import java.util.*;
class Solution {
    
    public int squareFreeSubsets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = Map.of(2,1,3,2,5,3,7,4,11,5,13,6,17,7,19,8,23,9,29,10);

        Integer dp[][] = new Integer[n][1<<11];

        return solve(0, 0, nums, dp, n, map);
    }

    private int solve(int i, int curr, int nums[], Integer dp[][], int n, Map<Integer, Integer> map){
        if(i==n){
            if(curr ==0) return 0;
            return 1;
        }
        if(dp[i][curr] !=null) return dp[i][curr];

        int ans = 0;
        int mask = getMask(nums[i], map);
        if((mask !=0 && (mask & curr) ==0 )|| nums[i]== 1){
            ans = solve(i+1, curr | mask, nums, dp, n, map);
        }

        return dp[i][curr] = add(ans, solve(i+1, curr, nums, dp, n, map));
    }



    private int add(int a, int b){
        long mod = (long)1e9 + 7;
        long sum = 1l*a + b;

        return (int)(sum%mod);
    }

    private int getMask(int x, Map<Integer, Integer> map){
        int mask = 0;

        for(int i=2;i<=Math.sqrt(x);i++){
            int cnt = 0;
            while(x %i==0){
                x/=i;
                cnt++;
            }
            if(cnt == 1){
                mask |= (1<<map.get(i));
            }else if(cnt !=0 ){
                return 0;
            }
        }

        if(x > 1){
            mask |=(1<<map.get(x));
        }
        if(mask ==0) return 1;
        return mask;
    }


}