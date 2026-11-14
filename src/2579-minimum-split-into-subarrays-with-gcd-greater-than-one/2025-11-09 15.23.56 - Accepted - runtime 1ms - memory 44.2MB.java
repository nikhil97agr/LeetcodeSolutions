class Solution {
    public int minimumSplits(int[] nums) {
       int ans = 1;
        int gcd = nums[0];
       for(int x : nums){
            gcd = gcd(x, gcd);
            if(gcd ==1){
                gcd = x;
                ans++;
            }
       }

       return ans;
    }
    int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a, a);
    }
}