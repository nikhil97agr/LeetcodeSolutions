class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int n = nums.length;
        int end = 0;
        int cnt = 0;
        int ans = 0;
        while(end<n){
            if(nums[end]==0){
                cnt++;
            }

            while(cnt>k && start<=end){
                if(nums[start]==0){
                    cnt--;
                }
                start++;
            }

            ans = Math.max(ans, end-start+1);
            end++;
        }
        return ans;
    }
}