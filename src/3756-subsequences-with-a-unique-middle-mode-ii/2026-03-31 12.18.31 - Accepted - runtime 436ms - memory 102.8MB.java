import java.util.HashMap;
import java.util.Map;

class Solution {

    int mod = 1_000_000_007;
    int fact[];
    int inv[];

    public int subsequencesWithMiddleMode(int[] nums) {

        int n = nums.length;
        fact = new int[n + 1];
        inv = new int[n + 1];
        fact[0] = fact[1] = 1;
        inv[0] = inv[1] = 1;
        for (int i = 2; i <= n; i++) {
            fact[i] = prod(i, fact[i - 1]);
            inv[i] = pow(fact[i], mod - 2);
        }
        int ans = 0;
        var preCnt = new HashMap<Integer, Integer>();
        var sufCnt = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            add(nums[i], sufCnt);
        }
        int suffSqSum = 0;
        int preSqSum = 0;
        int preSufSum = 0;
        int preSqSuffSum = 0;
        int preSuffSqSum = 0;
        for (var val : sufCnt.values()) {
            suffSqSum = add(suffSqSum, prod(val, val));
        }
        int right = n;
        int left = 0;
        for (int i = 0; i < n; i++) {
            right--;
            remove(nums[i], sufCnt);

            var cPre = preCnt.getOrDefault(nums[i], 0);
            var cSuf = sufCnt.getOrDefault(nums[i], 0);

            suffSqSum = add(suffSqSum, -prod(cSuf + 1, cSuf + 1));
            preSqSum = add(preSqSum, -prod(cPre, cPre));
            preSufSum = add(preSufSum, -prod(cPre, cSuf + 1));
            preSqSuffSum = add(preSqSuffSum, -prod(cPre, prod(cPre, cSuf + 1)));
            preSuffSqSum = add(preSuffSqSum, -prod(cPre, prod(cSuf + 1, cSuf + 1)));

            ans = add(ans, prod(comb(left, 2), comb(right, 2)));

            ans = add(ans, -prod(comb(left - cPre, 2), comb(right - cSuf, 2)));

            int preRemain = left - cPre;
            int sufRemain = right - cSuf;


            int a = add(preSqSum, -preRemain);
            a = prod(a, cSuf);
            a = prod(a, sufRemain);
            a = prod(a, pow(2, mod - 2));
            ans = add(ans, -a);

            int b = add(suffSqSum, -sufRemain);
            b = prod(b, cPre);
            b =prod(b, preRemain);
            b = prod(b, pow(2, mod - 2));
            ans = add(ans, -b);

            int c = prod(cPre, right);
            c = add(c, prod(cSuf, left));

            int d = prod(2, prod(cPre, cSuf));
            c = add(c, -d);

            int e = prod(preSufSum, c);
            ans = add(ans, -e);

            ans = add(ans, prod(preSqSuffSum, cSuf));
            ans = add(ans, prod(preSuffSqSum, cPre));


            left++;
            add(nums[i], preCnt);

            suffSqSum = add(suffSqSum, prod(cSuf, cSuf));
            preSqSum = add(preSqSum, prod(cPre + 1, cPre + 1));
            preSufSum = add(preSufSum, prod(cPre + 1, cSuf));
            preSqSuffSum = add(preSqSuffSum, prod(cPre + 1, prod(cPre + 1, cSuf)));
            preSuffSqSum = add(preSuffSqSum, prod(cPre + 1, prod(cSuf, cSuf)));

        }

        return ans;
    }


    private void remove(int val, Map<Integer, Integer> map) {

        map.merge(val, -1, Integer::sum);
        if (map.get(val) == 0) {
            map.remove(val);
        }
    }

    private void add(int val, Map<Integer, Integer> map) {

        map.merge(val, 1, Integer::sum);
    }

    private int comb(int n, int r) {

        if (r > n) {
            return 0;
        }
        if (r == n) {
            return 1;
        }
        return prod(fact[n], prod(inv[r], inv[n - r]));
    }

    private int add(int a, int b) {

        long sum = 1l * a + b + mod;

        return (int) (sum % mod);
    }

    private int prod(int a, int b) {

        long p = 1l * a * b;
        return (int) (p % mod);
    }

    private int pow(int a, int b) {

        int p = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                p = prod(p, a);
            }

            a = prod(a, a);
            b >>= 1;
        }

        return p;
    }
}