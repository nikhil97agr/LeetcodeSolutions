class Solution {
    int mod = 1_000_000_007;
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        int ans = 0;
        int c1 = 0;
        int c2 = 0;

        for(var x : nums){
            if(x < a){
                ans = add(ans, add(c1, c2));
            }else if(x <= b){
                ans = add(ans, c2);
                c1 = add(c1, 1);
            }else{
                c2 = add(c2, 1);
            }
        }

        return ans;
    }

    private int add(long a, long b){
        long sum = a + b + mod;

        return (int)(sum%mod);
    }
}