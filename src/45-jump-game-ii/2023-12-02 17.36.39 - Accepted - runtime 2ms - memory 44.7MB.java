class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        int curr = 0;
        int nextMax = nums[0];
        int n = nums.length;
        if(n==1) return 0;

        for(int i=0;i<n;i++){
            if(i==n-1) return ans;
            if(curr==0){
                curr = nextMax;
                nextMax = 0;
                ans++;
            }else{
                curr--;
                nextMax--;
                nextMax = Math.max(nextMax, nums[i]);
                if(curr==0){
                    curr = nextMax;
                    nextMax = 0;
                    ans++;
                }
            }
        }
        
        return ans;

    }
}