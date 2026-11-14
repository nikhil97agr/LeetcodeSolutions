class Solution {
    public long countSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length;
        long cnt = 1;
        for(int i=1;i<n;i++){
            if(nums[i] > nums[i-1]) cnt++;
            else{
                ans += (cnt*(cnt+1))/2;
                cnt=1;
            }
        }

        return ans + (cnt*(cnt+1))/2;
    }
}