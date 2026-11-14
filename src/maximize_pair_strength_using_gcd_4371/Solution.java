package maximize_pair_strength_using_gcd_4371;

class Solution {
    public long maxPairStrength(int[] nums) {
        long ans = 0;
        var n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long gcd = gcd(nums[i], nums[j]);
                gcd = gcd * gcd;
                ans = Math.max(ans, (1l * nums[i] * nums[j])/gcd);
            }
        }

        return ans;
    }

    private long gcd(long a, long b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}