package minimum_distance_to_the_target_element_1975;

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int ans = 10001;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                ans = Math.min(ans, Math.abs(i-start));
            }
        }
        return ans;
    }
}