package maximum_subarray_sum_after_multiplier_3730;

class Solution {


    public long maxSubarraySum(int[] nums, int k) {

        long min = Long.MIN_VALUE / 2;
        long maxSum = min;
        long mult = min;
        long div = min;
        long max2 = min;
        long ans = min;

        for (var x : nums) {
            var prod = 1l * x * k;
            var d = x >= 0 ? floor(x, k) : ceil(x, k);

            var n1 = Math.max(x, max2 + x);
            n1 = Math.max(n1, mult + x);
            n1 = Math.max(n1, div + x);

            var n2 = Math.max(prod, mult + prod);
            n2 = Math.max(n2, maxSum + prod);
            
            var n3 = Math.max(d, div + d);
            n3 = Math.max(n3, maxSum + d);

            var n4 = Math.max(x, maxSum + x);

            max2 = n1;
            mult = n2;
            div = n3;
            maxSum = n4;

            var curr = Math.max(max2, mult);
            curr = Math.max(curr, div);
            curr = Math.max(curr, maxSum);

            ans = Math.max(ans, curr);
        }

        return ans;
    }

    private long ceil(int x, int k) {

        return (long) Math.ceil((1d * x) / k);
    }

    private long floor(int x, int k) {

        return (x / k);
    }
}