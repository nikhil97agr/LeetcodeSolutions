import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {

    Map<Long, Integer> dp;

    public int maxProduct(int[] nums, int k, int limit) {
        int sum = Arrays.stream(nums).sum();

        if(sum < k || k < -sum) return -1;
        dp = new HashMap<>();

        return solve(0, 0, 0, 0, k, limit, nums);
    }

    private int solve(int i, int sum, int prevOp, int prod, int k, int limit, int nums[]) {

        if (i == nums.length) {
            if (sum != k || prevOp == 0 || prod > limit) {
                return -1;
            }
            return prod;
        }
        long key = getKey(i, sum, prod, prevOp);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        int ans = solve(i + 1, sum, prevOp, prod, k, limit, nums);

        if (prevOp == 0) {
            ans = Math.max(ans, solve(i + 1, sum + nums[i], 2, nums[i], k, limit, nums));
        } else if (prevOp == 1) {
            ans = Math.max(ans, solve(i + 1, sum + nums[i], 2, Math.min(nums[i] * prod, limit + 1), k, limit, nums));
        } else {
            ans = Math.max(ans, solve(i + 1, sum - nums[i], 1, Math.min(nums[i] * prod, limit + 1), k, limit, nums));
        }

        dp.put(key, ans);
        return ans;
    }

    private long getKey(int a, int b, int c, int d){
        b += 2000;

        return (((1l*a * 1001) + b )* 5003 + c)*3 + d;
    }

}