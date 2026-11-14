class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long pre[] = new long[n];
        pre[0] = nums[0];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + nums[i];
        }

        long suff[] =new long[n];
        suff[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i] = Math.min(suff[i+1], nums[i]);
        }

        long res = Long.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            res = Math.max(res, pre[i] - suff[i+1]);
        }

        return res;
    }
}