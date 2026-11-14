class Solution {
    public int longestAlternatingSubarray(int[] nums, int t) {
        int start = 0;
        int ans = 0;
        int end = 0;
        int n = nums.length;
        while(start<n){
            int count = 0;
            if(nums[end]%2==0 && nums[end]<=t){
                end++;
                count++;
                while(end<n && nums[end]<=t && nums[end]%2 != nums[end-1]%2){
                    count++;
                    end++;
                }
                ans = Math.max(ans, count);
            }
            start++;
            end = start;
        }
return ans;
    }
}