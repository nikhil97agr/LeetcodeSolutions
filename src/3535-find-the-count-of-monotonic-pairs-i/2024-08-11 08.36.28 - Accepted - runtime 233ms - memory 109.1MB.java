import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countOfPairs(new int[]{2,3,2}));
    }
    long mod = (long)1e9+7;
    public int countOfPairs(int[] nums) {
        int max= Arrays.stream(nums).max().getAsInt();
        Long dp[][][] = new Long[nums.length][max+1][max+1];
        int n = nums.length;
        return (int)solve(nums, 0, n, dp, 0, max);
    }


    private long solve(int nums[], int i, int n, Long dp[][][], int a, int b){
        if(i==n){
            return 1;
        }

        if(dp[i][a][b]!=null) {
            return dp[i][a][b];
        }
        long ans = 0;
        for(int j=a;j<=nums[i];j++){
            int next = nums[i] - j;
            if(next <= b){
                ans += solve(nums, i+1, n, dp, j, next)%mod;
                ans%=mod;
            }
        }
        return dp[i][a][b] = ans%mod;
    }
}