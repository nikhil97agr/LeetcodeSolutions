class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int xor = 0;
        for(int x : nums){
            xor ^= x;
        }

        for(int q[] :queries){
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            for(int i=l;i<=r;i+=k){
                xor ^= nums[i];
                nums[i] = prod(nums[i], v);
                xor ^= nums[i];
            }
        }

        return xor;
    }

    int prod(int a, int b){
        long mod = (long)1e9 + 7;
        long prod = 1l*a*b;

        return (int)(prod%mod);
    }
}