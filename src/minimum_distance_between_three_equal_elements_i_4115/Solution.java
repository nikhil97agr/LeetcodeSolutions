package minimum_distance_between_three_equal_elements_i_4115;

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans= Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(i!=j && i!=k && k!=j){
                        if(nums[i] == nums[j] && nums[j] == nums[k]){
                            ans = Math.min(ans, Math.abs(i-j) + Math.abs(i-k) + Math.abs(j-k));
                        }
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}