class Solution {
    public long minArraySum(int[] nums, int k) {
        long dp[] = new long[k+1];
        long max = 1_000_000_000_000l;
        Arrays.fill(dp,max);
        long sum =0;
        dp[0] = 0;
        for(int val : nums){
            sum += val;
            int mod = (int)(sum % k);
            /*
            * if there exist some sum before at position mod which is 
            * smaller than current sum that means subarray from that index to i is divisible
            * by k. and deleting curent sub array will result in left minimum sum dp[mod];
            */
            if(dp[mod] != max && dp[mod] < sum){
                sum = dp[mod];
            }else{
                dp[mod] = sum;
            }
        }

        return sum;

    }
}