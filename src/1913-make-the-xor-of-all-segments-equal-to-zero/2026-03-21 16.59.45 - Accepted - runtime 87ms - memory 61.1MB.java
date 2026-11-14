class Solution {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int cnt[][] = new int[k][1024];
        int indexCnt[] = new int[k];
        for(int i=0;i<n;i++){
            cnt[i%k][nums[i]]++;
            indexCnt[i%k]++;
        }

        int dp[] = new int[1024];
        Arrays.fill(dp, 1_000_000);

        dp[0] = 0;

        for(int i=0;i<k;i++){
            int nextDp[] = new int[1024];
            int ans = Arrays.stream(dp).min().getAsInt();
            Arrays.fill(nextDp, ans + indexCnt[i]);

            for(int j=0;j<1024;j++){
                if(cnt[i][j] > 0){
                    for(int x =0;x<1024;x++){
                        nextDp[j ^ x] = Math.min(nextDp[x ^ j], dp[x] + indexCnt[i] - cnt[i][j]);
                    }
                }
            }

            dp = nextDp;

        }

        return dp[0];


    }
}