class Solution {

    public long minOperations(int[] nums, int k) {

        var even = compute(nums, k, 0);
        var odd = compute(nums, k, 1);

        if (even.x1 != odd.x1) {
            return even.c1 + odd.c1;
        }

        long a1 = even.c1 + odd.c2;
        long a2 = even.c2 + odd.c1;

        return Math.min(a1, a2);
    }

    private Result compute(int arr[], int k, int start) {

        int len = 2 * k;

        int cnt[] = new int[len];
        int preCnt[] = new int[len + 1];
        long preSum[] = new long[len + 1];
        for (int i = start; i < arr.length; i += 2) {
            int mod = arr[i] % k;
            cnt[mod]++;
            cnt[mod + k]++;
        }

        for (int i = 0; i < len; i++) {
            preCnt[i + 1] = preCnt[i] + cnt[i];
            preSum[i + 1] = preSum[i] + 1l * i * cnt[i];
        }

        int x1 = 0;
        int x2 = 0;
        long c1 = Long.MAX_VALUE;
        long c2 = Long.MAX_VALUE;

        for (int s = 0, e = k - 1; s < k; s++, e++) {
            int mid = (s + e) / 2;

            var left = compute(preSum, preCnt, s, mid + 1);
            var right = compute(preSum, preCnt, mid + 1, e + 1);

            long req = 1l * left.cnt * mid - left.sum + right.sum - 1l * right.cnt * mid;

            if (req < c1) {
                c2 = c1;
                x2 = x1;
                c1 = req;
                x1 = mid;
            } else if (req < c2) {
                c2 = req;
                x2 = mid;
            }
        }

        return new Result(x1, x2, c1, c2);


    }

    public Pair compute(long preSum[], int preCnt[], int start, int end) {

        int cnt = preCnt[end] - preCnt[start];
        long sum = preSum[end] - preSum[start];

        return new Pair(cnt, sum);
    }
    
    class Pair {

        int cnt;
        long sum;

        public Pair(int cnt, long sum) {

            this.cnt = cnt;
            this.sum = sum;
        }

        public Pair add(Pair pair) {

            return new Pair(cnt + pair.cnt, sum + pair.sum);
        }
    }

    class Result {

        int x1;
        int x2;
        long c1;
        long c2;

        public Result(int x1, int x2, long c1, long c2) {

            this.x1 = x1;
            this.x2 = x2;
            this.c1 = c1;
            this.c2 = c2;
        }
    }

}