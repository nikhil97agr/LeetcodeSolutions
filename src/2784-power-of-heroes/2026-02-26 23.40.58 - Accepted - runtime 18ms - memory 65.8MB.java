class Solution {
    public int sumOfPower(int[] nums) {
        int ans = 0;
        int sum = 0;

        Arrays.sort(nums);
        for(int x : nums){
            ans = add(ans, prod(x, prod(x, add(sum, x))) );
            sum = add(x, prod(sum, 2));
        }
        return ans;
    }
    long mod = (long)1e9 + 7;
    private int add(long a, long b){
        return (int)((a + b)%mod);
    }

    private int prod(long a, long b){
        return (int)((a*b)%mod);
    }
}