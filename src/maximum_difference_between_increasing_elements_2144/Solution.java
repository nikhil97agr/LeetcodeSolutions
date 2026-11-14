package maximum_difference_between_increasing_elements_2144;

class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int min = nums[0];
        int n= nums.length;
        for(int i=1;i<n;i++){
            if(nums[i] > min){
                ans = Math.max(ans, nums[i] - min);
            }

            min = Math.min(min, nums[i]);
        }

        return ans;
    }
}