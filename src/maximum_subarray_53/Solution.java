package maximum_subarray_53;

class Solution {
    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        for(int x : nums){
            max = Math.max(max, x);
        }

        if(max <=0) return max;
       int ans = Integer.MIN_VALUE;
       int sum = 0;
       int i=0;
       int j=0;
       int n = nums.length;
       while(i<n && j<n){
           sum += nums[i];
           ans = Math.max(ans, sum);
           if(sum  < 0){
               while(j <=i && sum < 0){
                   sum -= nums[j];
                   j++;
               }
               ans = Math.max(ans, sum);
           }
           i++;
       }

       
       return ans;
    }
}