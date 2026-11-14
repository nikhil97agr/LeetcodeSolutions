import java.util.Arrays;

class Solution {

    int mod = 1_000_000_007;
    long total = 0;

    public int countPartitions(int[] nums, int k) {

        int n = nums.length;
        total = Arrays.stream(nums).mapToLong(x -> x).sum();
        if (total < 2 * k) {
            return 0;
        }

        int cnt = pow(2, n);

        int dp[] = new int[k];
        dp[0] =1;
        for (int x : nums) {
            for (int i = k - 1 - x; i >= 0; i--) {
                dp[i + x] = add(dp[i + x], dp[i]);
            }
        }

        for(int i=0;i<k;i++){
            if(total -i < k){
                cnt = add(cnt, -dp[i]);
            }else{
                cnt = add(cnt, -prod(dp[i], 2));
            }
        }
        return cnt;

    }

    private int pow(int a, int b) {

        if (a == 0 || b == 1) {
            return a;
        }
        if (b == 0 || a == 1) {
            return 1;
        }
        int p = pow(a, b / 2);
        p = prod(p, p);
        if (b % 2 == 1) {
            p = prod(a, p);
        }

        return p;
    }

    private int add(long a, long b) {

        return (int) ((a + b + mod) % mod);
    }

    private int prod(long a, long b) {

        return (int) ((a * b) % mod);
    }

}