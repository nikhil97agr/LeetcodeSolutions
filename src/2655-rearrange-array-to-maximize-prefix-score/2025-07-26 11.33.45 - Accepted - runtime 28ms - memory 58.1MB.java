class Solution {
    public int maxScore(int[] nums) {
        int ans = 0;
        long sum =0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            sum += nums[i];
            if(sum >0) ans++;
            else break;
        }

        return ans;
    }
}