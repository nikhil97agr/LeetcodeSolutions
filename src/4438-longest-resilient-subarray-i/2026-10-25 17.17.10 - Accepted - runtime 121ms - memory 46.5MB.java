class Solution {
    public int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = 1;
        for(int i=0;i<n;i++){
            int sum =0;
            int rem = nums[i]%k;

            for(int j=i;j<n ;j++){
                sum += nums[j];
                sum%=k;
                if(nums[j]%k != rem){
                    break;
                }
                if(sum == rem){
                    ans = Math.max(j - i + 1, ans);
                }
            }
        }

        return ans;
    }
}