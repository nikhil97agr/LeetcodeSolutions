class Solution {
    public long minOperations(int[] nums) {
        long ans = 0;
        long sum = 0;
        int n = nums.length;
        long arr[] = new long[n];
        for(int i=0;i<n;i++) arr[i] = nums[i];
        for(int i=1;i<nums.length;i++){
            arr[i] += sum;
            if(arr[i] >= arr[i-1]){
                continue;
            }

            long diff = arr[i-1] - arr[i];
            sum += diff;
            ans+= diff;
            arr[i] = arr[i-1];
        }

        return ans;
    }
    
}