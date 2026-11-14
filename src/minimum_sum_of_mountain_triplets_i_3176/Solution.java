package minimum_sum_of_mountain_triplets_i_3176;

class Solution {
    public int minimumSum(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i] < nums[j] && nums[k] < nums[j]){
                        ans = Math.min(ans, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        
        return ans==Integer.MAX_VALUE ? -1 : ans;    
    }
    
}