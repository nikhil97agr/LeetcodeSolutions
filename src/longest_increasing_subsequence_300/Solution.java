package longest_increasing_subsequence_300;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        for(int i=0;i<n;i++){
            result[i] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    result[i] = Math.max(result[i], result[j]+1);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.max(ans, result[i]);
        }
        return ans;
    }
}