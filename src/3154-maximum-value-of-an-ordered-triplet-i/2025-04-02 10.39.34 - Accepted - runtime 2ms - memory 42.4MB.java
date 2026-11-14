class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for(int i=0;i<n;i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    ans = Math.max(ans, 1l*(nums[i] - nums[j])*nums[k]);
                }
            }
            
        }
        
        return ans;
        
    }
}