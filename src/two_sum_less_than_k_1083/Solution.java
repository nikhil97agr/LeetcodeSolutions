package two_sum_less_than_k_1083;

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int ans = -1;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum = nums[i] + nums[j];
                if(sum < k){
                    ans = Math.max(ans, sum);
                }
            }
        }

        return ans;
    }
}