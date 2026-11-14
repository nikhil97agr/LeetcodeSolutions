class Solution {
    long mod = (long)1e9 + 7;
    public int sumOfBlocks(int n) {
        int i = 1;
        int next = 1;
        int ans =0;
        while(i <= n){
            int prod = 1;
            int cnt = 0;
            while(cnt < i){
                prod = prod(prod, next);
                next++;
                cnt++;
            }
            ans = sum(ans, prod);
            i++;
        }

        return ans;
    }

    private int prod(int a, int b){
        long p = 1l*a*b;
        return (int)(p%mod);
    }

    private int sum(int a, int b){
        long sum = 1l*a + b;
        return (int)(sum%mod);
    }
}