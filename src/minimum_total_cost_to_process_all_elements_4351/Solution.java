package minimum_total_cost_to_process_all_elements_4351;

class Solution {

    long mod = (long) 1e9 + 7;

    public static void main(String[] args) {

        new Solution().minimumCost(new int[]{1, 2, 3, 4}, 4);
    }

    public int minimumCost(int[] nums, int k) {

        long resource = k;

        long ans = 0;
        long nextCost = 1;
        for (long x : nums) {
            if (resource >= x) {
                resource -= x;
                continue;
            }

            long diff = x - resource;
            long req = (diff + k - 1) / k;
            long start = nextCost;
            long end = start + req - 1;
            long a = prod(req, add(start, end));
            long b = pow(2, mod - 2);
            long cost = prod(a, b);

            ans = add(ans, cost);
            nextCost = end + 1;
            resource += (req * k);

            resource -= x;

        }

        return (int) ans;

    }

    private long add(long a, long b) {

        return (a + b) % mod;
    }

    private long prod(long a, long b) {

        return (a * b) % mod;
    }

    private long pow(long a, long b) {

        long ans = 1;

        while (b > 0) {

            if (b % 2 == 1) {
                ans = prod(a, ans);
            }

            a= prod(a,a);

            b /= 2;
        }

        return ans;
    }
}