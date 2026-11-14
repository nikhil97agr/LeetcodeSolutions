package ways_to_split_array_into_good_subarrays_2867;

class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        Integer dp[][] = new Integer[nums.length][2];
        return solve(0, 0, nums, dp);
    }


    private int solve(int i, int cnt, int nums[], Integer dp[][]){

        if(i == nums.length) {
            return cnt ==0 ? 0 : 1;
        }

        if(dp[i][cnt] != null) {
            return dp[i][cnt];
        }


        if(nums[i] == 1){
            return  dp[i][cnt] = solve(i+1, 1, nums, dp);
        }else{
            if(cnt == 0){
                return dp[i][cnt] = solve(i+1, 0, nums, dp);
            }else{
                return dp[i][cnt] = sum(solve(i+1, 0, nums, dp), solve(i+1, 1, nums, dp));
            }
        }


    }
    int sum(long a, long b){
        long mod = (long)1e9 + 7;

        return (int)((a+b)%mod);
    }
}