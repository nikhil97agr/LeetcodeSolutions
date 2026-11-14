package maximum_points_you_can_obtain_from_cards_1538;

class Solution {
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int pre[] = new int[n+1];

        pre[0] = 0;

        for(int i=1;i<=n;i++){
            pre[i] = pre[i-1] + nums[i-1];
        }
        int ans = pre[n] - pre[n-k];
        for(int i=1;i<=k;i++){
            int start = pre[i];
            int end = pre[n] - pre[n-k + i];
            ans = Math.max(ans, start + end);
        }
        
        return ans;
    }
}