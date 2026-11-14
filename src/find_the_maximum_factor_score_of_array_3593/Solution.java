package find_the_maximum_factor_score_of_array_3593;

class Solution {
    public long maxScore(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0] * nums[0];
        long ans = 0;
        for(int i=0;i<n;i++){
            long lcm = 1;
            long gcd = 1;
            long g = nums[0];
            if(i==0){
                g = nums[1];
            }

            for(int j=0;j<n;j++){
                if(j==i) continue;
                gcd = gcd(lcm, nums[j]);
                g = gcd(g, nums[j]);
                lcm = (lcm * nums[j])/gcd;
            }
            ans = Math.max(ans, lcm * g);
        }
        long lcm = 1;
        long gcd = 1;
        long g = nums[0];
        for(int i=0;i<n;i++){
            gcd = gcd(lcm, nums[i]);
            g = gcd(g, nums[i]);
            lcm = (lcm * nums[i])/gcd;
        }

        return Math.max(ans, g * lcm);
    }

    private long gcd(long a, long b){
        if(a==0){
            return b;
        }

        return gcd(b%a, a);
    }
}