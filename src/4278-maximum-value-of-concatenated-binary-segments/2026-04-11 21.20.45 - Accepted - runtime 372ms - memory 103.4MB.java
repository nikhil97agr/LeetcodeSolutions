import java.util.Arrays;

class Solution {

    int mod = 1_000_000_007;

    public int maxValue(int[] nums1, int[] nums0) {

        var n = nums1.length;
        var pair = new int[n][2];
        var totalLength = 0;
        int extra = 0;
        for (var i = 0; i < n; i++) {
            if (nums1[i] == 0) {
                totalLength += nums0[i];
                continue;
            }

            if (nums0[i] == 0) {
                extra += nums1[i];
                totalLength += nums1[i];
                continue;
            }

            pair[i] = new int[]{nums1[i], nums0[i]};
            totalLength += nums1[i];
            totalLength += nums0[i];
        }

        var pow = new int[totalLength + 1];
        pow[0] = 1;
        for (int i = 1; i <= totalLength; i++) {
            pow[i] = prod(pow[i - 1], 2);
        }

        Arrays.sort(pair, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }

            return b[0] - a[0];
        });

        int ans = 0;
        var lastIndex = totalLength - 1;
        while(extra-- >0){
            ans =add(ans, pow[lastIndex]);
            lastIndex--;
        }
        for (var p : pair) {
            var one = p[0];
            var zero = p[1];
            while(one--> 0){
                ans = add(ans, pow[lastIndex]);
                lastIndex--;
            }
            lastIndex -= zero;
            
        }

        return ans;
    }


    private int add(long a, long b) {

        return (int) ((a + b + mod) % mod);
    }

    private int prod(long a, long b) {

        return (int) ((a * b) % mod);
    }

}