class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int x : nums) sum+=x;
        
        int ans = 0;
        int total =0;
        for(int i=0;i<nums.length-1;i++){
            total += nums[i];
            sum -= nums[i];
            if((total - sum)%2==0) ans++;
        }
        return ans;
    }
}