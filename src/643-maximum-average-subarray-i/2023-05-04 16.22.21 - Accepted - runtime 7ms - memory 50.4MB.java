class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i=0;i<k;i++){
            sum +=nums[i];
        }
       double max = sum/k;
       int start = 0;
       int n = nums.length;
       int i=k;
       while(i<n){
           sum = sum - nums[start] + nums[i];
           max = Math.max(max, sum/k);
           start++;
           i++;
       }
       return max;
    }


}