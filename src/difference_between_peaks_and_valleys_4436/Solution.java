package difference_between_peaks_and_valleys_4436;

class Solution {
    public int peakValleyDifference(int[] nums) {
        int ans = 0;
        for(int i=1;i<nums.length - 1;i++){
            if(nums[i] > nums[i + 1] && nums[i] > nums[i - 1]){
                ans += nums[i];
            }

            if(nums[i] < nums[i + 1] && nums[i] < nums[i - 1]){
                ans -= nums[i];
            }
        }

        return ans;
    }
}