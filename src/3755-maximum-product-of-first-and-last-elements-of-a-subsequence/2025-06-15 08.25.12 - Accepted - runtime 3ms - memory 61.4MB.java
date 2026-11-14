class Solution {
    public long maximumProduct(int[] nums, int m) {
        long ans = Long.MIN_VALUE;;
        int n = nums.length;
        int i=0;
        int j=0;
        int min = nums[0];
        int max = nums[0];
        while(j < n){
            if(j-i+1 < m){
                j++;
                continue;
            }

             max = Math.max(nums[i], max);
             min = Math.min(nums[i], min);
            i++;
            ans= Math.max(ans, 1l*nums[j]*max);
            ans = Math.max(ans, 1l*nums[j]*min);
            j++;
            
        }


        return ans;

        
    }
}