package maximize_score_after_pair_deletions_3839;

class Solution {
    public int maxScore(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int pre[] = new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1] = nums[i] + pre[i];
        }

        if(n%2==0){
            ans = pre[n] - pre[2];
            for(int i=0;i+3 <= n;i++){
                ans = Math.max(ans, pre[i+1] + (pre[n] - pre[i+3]));
            }
        }else{
            ans = pre[n] - pre[1];
            for(int i=0;i+2 <=n;i++){
                ans = Math.max(ans, pre[i+1] + (pre[n] - pre[i+2]));
            }
        }

        return ans;
    }
}