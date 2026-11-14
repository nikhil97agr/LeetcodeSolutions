class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        boolean res[] = new boolean[n];

        for(int i=2;i<n;i++){
            if(nums[i] == nums[i-1] + nums[i-2]){
                res[i] = true;
            }
        }

        int ans = 0;
        int cnt = 0;

        for(int i=0;i<n;i++){
            if(res[i]){
                cnt++;
            }else{
                cnt = 0;
            }

            ans = Math.max(ans, cnt);
        }

        return ans + 2;
    }
}