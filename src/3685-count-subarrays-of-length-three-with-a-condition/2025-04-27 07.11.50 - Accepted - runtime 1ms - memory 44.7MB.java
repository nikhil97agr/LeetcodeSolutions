class Solution {
    public int countSubarrays(int[] nums) {
        int ans = 0;
        int n= nums.length;
        for(int i=0;i<n-2;i++){
            int sum = nums[i] + nums[i+2];
            int mid= nums[i+1];
            if(mid%2==0 && sum == mid/2) ans++;
        }
        return ans;
    }
}