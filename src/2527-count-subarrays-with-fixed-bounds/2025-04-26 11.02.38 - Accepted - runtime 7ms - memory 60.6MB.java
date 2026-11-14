class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int start = -1;
        int min = -1;
        int max = -1;
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=minK && nums[i] <= maxK){
                min = nums[i] == minK ? i : min;
                max = nums[i] == maxK ? i : max;
                ans += 1l*(Math.max(0, Math.min(min, max)-start));
            }else{
                start = i;
                min = -1;
                max = -1;
            }
        }
        return ans;
    }
}