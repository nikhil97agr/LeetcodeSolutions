package valid_subarrays_with_exactly_one_peak_4269;

class Solution {
    public long validSubarrays(int[] nums, int k) {
        int leftPeak = -1;
        int n = nums.length;
        int rightPeak = n;
        long ans = 0;
        for(int i=n-2;i>0;i--){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                rightPeak = i;
            }
        }

        for(int i=1;i<n-1;i++){
            if(nums[i] <= nums[i-1] || nums[i] <= nums[i+1]){
                continue;
            }
            rightPeak = Math.max(rightPeak, i+1);
            while(rightPeak < n -1 && (nums[rightPeak] <= nums[rightPeak-1] || nums[rightPeak] <= nums[rightPeak + 1])){
                rightPeak++;
            }
            if(rightPeak == n-1){
                rightPeak = n;
            }

            int leftLen = Math.min(k + 1, i - leftPeak);
            int rightLen = Math.min(k+1, rightPeak - i);
            ans += 1l * leftLen * rightLen;
            leftPeak = i;
        }

        return ans;
    }
}