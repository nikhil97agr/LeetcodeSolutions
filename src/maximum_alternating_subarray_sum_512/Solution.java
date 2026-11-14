package maximum_alternating_subarray_sum_512;

class Solution {
    public long maximumAlternatingSubarraySum(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(max(nums.clone(), 0), max(nums.clone(), 1));
    }

    private long max(int arr[], int parity){
        int n = arr.length;
        for(int i=parity;i<n;i+=2){
            arr[i] = -arr[i];
        }

        long sum = 0;
        long ans= Long.MIN_VALUE;

        for(int i=(parity^1);i<n;i++){
            sum += arr[i];
            ans = Math.max(ans, sum);

            if(i%2!=parity){
                sum= Math.max(sum, arr[i]);
                ans = Math.max(ans, sum);
            }else{
                sum = Math.max(sum, 0);
            }
        }
        return ans;


    }
}