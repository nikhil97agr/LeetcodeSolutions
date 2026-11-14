package number_of_subarrays_with_lcm_equal_to_k_2557;

class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        int n  = nums.length;
        for(int i=0;i<n;i++){
            int lcm = 1;
            for(int j=i;j<n;j++){
                lcm = (lcm * nums[j])/gcd(lcm, nums[j]);
                if(lcm > k) break;
                if(lcm == k) ans++;
            }
        }

        return ans;
    }
    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}