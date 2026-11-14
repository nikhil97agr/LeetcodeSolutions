class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int ans1=0;
        int ans2 = 0;
        
        int n = nums.length;
        if(n==1) return 0;
        for(int i=1;i<n;i+=2){
            int first = nums[i] >= nums[i-1] ? abs(nums[i] - nums[i-1] + 1) : 0;
            int second = i<n-1 && nums[i] >= nums[i+1] ? abs(nums[i] - nums[i+1] +1 ) : 0;
            ans1 += Math.max(second, first);
        }

        for(int i=0;i<n;i+=2){
            int first = i < n-1  && nums[i] >= nums[i+1] ? abs(nums[i] - nums[i+1] +1 ) : 0;
            int second = i > 0 && nums[i] >= nums[i-1]  ? abs(nums[i] - nums[i-1] + 1) : 0;
            ans2 += Math.max(second, first);
        }

        return Math.min(ans1, ans2);
    }

    private int abs(int a){
        return Math.abs(a);
    }
}