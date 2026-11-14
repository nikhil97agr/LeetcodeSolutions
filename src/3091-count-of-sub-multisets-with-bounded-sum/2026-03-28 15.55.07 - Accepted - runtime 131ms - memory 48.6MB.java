import java.util.HashMap;
import java.util.List;

class Solution {

    int mod = 1_000_000_007;

    public int countSubMultisets(List<Integer> nums, int l, int r) {

        var map = new HashMap<Integer, Integer>();
        for (var x : nums) {
            map.merge(x, 1, Integer::sum);
        }
        var dp = new int[r + 1];
        dp[0]= 1;
        for (var entry : map.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();

            var preSum = dp.clone();
            for (int sum = 0; sum <= r; sum++) {
                if (sum - num >= 0) {
                    preSum[sum] = add(preSum[sum], preSum[sum - num]);
                }
            }

            for (int sum = r; sum >= 0; sum--) {
                if (num > 0) {
                    int j = sum - prod(num, cnt + 1);
                    if (j >= 0) {
                        dp[sum] = add(preSum[sum], -preSum[j]);
                    } else {
                        dp[sum] = preSum[sum];
                    }
                } else {
                    dp[sum] = prod(dp[sum], cnt + 1);
                }
            }
        }
        
        var ans = 0;
        for(var i=l;i<=r;i++){
            ans = add(ans, dp[i]);
        }
        
        return ans;
    }

    private int add(int a, int b) {

        long sum = 1l * a + b + mod;
        return (int) (sum % mod);
    }

    private int prod(int a, int b) {

        long p = 1l * a * b;

        return (int) (p % mod);
    }
}