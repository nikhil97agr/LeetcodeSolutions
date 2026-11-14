package longest_alternating_subarray_2870;

class Solution {
    public int alternatingSubarray(int[] nums) {
        int ans =0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int j=i+1;
            int next = -1;
            for(;j<n;j++){
                if(next == -1){
                    if(nums[j] - 1 != nums[j-1]){
                        break;
                    }
                    next = 1;
                }else{
                    if(nums[j] + 1 != nums[j-1]){
                        break;
                    }
                    next = -1;
                }
            }

            ans = Math.max(ans, j-i);
        }
        return ans <= 1 ? -1 : ans;
    }
}