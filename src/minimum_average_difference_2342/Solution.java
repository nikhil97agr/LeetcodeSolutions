package minimum_average_difference_2342;

class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long left[] = new long[n];
        long right[] = new long[n];
        if(n==1){
            return 0;
        }
        long total = 0;
        for(int i=0;i<n;i++){
            total += nums[i];
            left[i] = total/(i+1);
        }
        total = nums[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = total/(n-1-i);
            total += nums[i];
        }
        long min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int i=0;i<n;i++){
            if(min > Math.abs(left[i]-right[i])){
                minIndex = i;
                min = Math.abs(left[i] - right[i]);
            }
        }
        return minIndex;



    }
}