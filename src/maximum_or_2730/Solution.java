package maximum_or_2730;

class Solution {
    public long maximumOr(int[] nums, int k) {
        int n =nums.length;

        long pre[] = new long[n+1];

        long suff[] = new long[n+1];

        for(int i=1;i<=n;i++){
            pre[i] = pre[i-1] | nums[i-1];
        }

        for(int i=n-1;i>=0;i--){
            suff[i] = suff[i+1] | nums[i];
        }

        long res = 0;

        for(int i=0;i<n;i++){
            res = Math.max(res, pre[i] | suff[i+1] | ((1l*nums[i]) << k));
        }

        return res;
    }
}