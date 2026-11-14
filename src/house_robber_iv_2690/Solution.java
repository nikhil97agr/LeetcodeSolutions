package house_robber_iv_2690;

class Solution {
    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int x : nums){
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        int ans = -1;
        int n = nums.length;
        while(min <= max){
            int mid = min + (max - min)/2;

            int cnt = getCnt(0, mid, nums, new Integer[n], n);
            if(cnt >= k){
                ans = mid;
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return ans;
    }

    private int getCnt(int i, int k, int nums[], Integer dp[], int n){
        if(i>=n){
            return 0;
        }

        if(dp[i]!=null) return dp[i];

        if(nums[i] <= k){
            return dp[i] = Math.max(1 + getCnt(i+2, k, nums, dp, n), getCnt(i+1, k, nums, dp, n));
        }
        return dp[i] = getCnt(i+1, k, nums, dp, n);
    }

    
}