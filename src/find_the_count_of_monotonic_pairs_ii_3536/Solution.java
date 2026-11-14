package find_the_count_of_monotonic_pairs_ii_3536;

class Solution {

    public int countOfPairs(int[] nums) {

        int dp[][] = new int[nums.length][1001];
        int n = nums.length;

        for (int j = 0; j <= nums[0]; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            int pre[] = new int[1001];
            pre[0] = dp[i-1][0];
            for(int j=1;j<=1000;j++){
                pre[j] = add(dp[i-1][j], pre[j-1]);
            }
            
            for(int j=0;j<=nums[i];j++){
                int k = Math.min(j, j + nums[i-1] - nums[i]);
                if(k >=0){
                    dp[i][j] = pre[k];
                }
            }
            
        }
        
        int ans =0;
        for(int j=0;j<=nums[n-1];j++){
            ans = add(ans, dp[n-1][j]);
        }
        
        return ans;

    }


    private int add(long a, long b) {

        int mod = (int) 1e9 + 7;

        return (int) ((a % mod + b % mod) % mod);
    }
}