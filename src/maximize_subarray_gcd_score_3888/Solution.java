package maximize_subarray_gcd_score_3888;

class Solution {
    public long maxGCDScore(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        for(int i=0;i<n;i++){
            int gcd = nums[i];
            int minPow = Integer.MAX_VALUE;
            int cnt = 0;
            for(int j=i;j<n;j++){
                gcd =gcd(nums[j], gcd);
                int pow = nums[j] & -nums[j];
                if(pow < minPow){
                    minPow = pow;
                    cnt = 0;
                }

                if(pow == minPow){
                    cnt++;
                }

                ans = Math.max(ans,
                    1l * (j - i + 1) * gcd  * ((cnt <=k) ? 2 : 1)
                );
            }
        }
        return ans;
    }

    private int gcd(int a, int b){
        if(b==0) return a;

        return gcd(b, a%b);
    }
}