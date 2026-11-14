import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<Integer, Map<Integer, Map<Integer, Integer>>> dp;
    private int max = Integer.MAX_VALUE;

    public int minimumValueSum(int[] nums, int[] andValues) {

        int n = nums.length;
        int m = andValues.length;
        dp = new HashMap<>();

        int ans = solve(0, -1, 0, nums, andValues, n, m);
        if (ans == max) {
            return -1;
        }
        return ans;
    }

    private int solve(int i, int mask, int j, int nums[], int andValues[], int n, int m) {

        if (i == n && j == m) {
            return 0;
        }
        if (i == n || j == m) {
            return max;
        }
        int existing = dp.getOrDefault(i, new HashMap<>()).getOrDefault(j, new HashMap<>()).getOrDefault(mask, -1);
        if(existing !=-1){
            return existing;
        }
        int ans = Integer.MAX_VALUE;
        int newMask = mask == -1 ? nums[i] : (mask & nums[i]);

        if (newMask < andValues[j]) {
            ans = max;
        }

        else if (newMask == andValues[j]) {
            int a = solve(i + 1, -1, j + 1, nums, andValues, n, m);
            int b = solve(i + 1, newMask, j, nums, andValues, n, m);
            if (a != max) {
                a += nums[i];
            }
            ans = Math.min(a,b);
        }else{
             ans = solve(i + 1, newMask, j, nums, andValues, n, m);
        }


        dp.computeIfAbsent(i, x-> new HashMap<>()).computeIfAbsent(j, y->new HashMap<>()).put(mask, ans);
        return ans;
    }

    private int key(int i, int mask, int j) {

        i++;
        j++;
        mask += 2;
        int mod = 1_000_000_007;

        return prod(add(prod(add(prod(i, mod, mod), j, mod), mod, mod), mask, mod), mod, mod);
    }

    private int add(long a, long b, int mod) {

        return (int) ((a + b) % mod);
    }

    private int prod(long a, long b, int mod) {

        return (int) ((a * b) % mod);
    }

}