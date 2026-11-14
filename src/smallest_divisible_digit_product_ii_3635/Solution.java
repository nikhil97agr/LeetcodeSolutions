package smallest_divisible_digit_product_ii_3635;

import java.util.*;
class Solution {
    public String smallestNumber(String num, long t) {
        if (invalid(t)) {
            return "-1";
        }
        var ch = num.toCharArray();
        var n = num.length();

        var gcd = new long[n + 1];
        Arrays.fill(gcd, t);
        for (int i = 0; i < n; i++) {
            int dig = ch[i] - '0';
            if (dig == 0)
                break;
            gcd[i + 1] = gcd[i] / gcd(gcd[i], dig);
        }

        if (gcd[n] == 1) {
            return num;
        }

        var zeroInd = num.indexOf("0") % n;
        if(zeroInd == -1){
            zeroInd = n-1;
        }

        for (var j = zeroInd; j >= 0; j--) {
            var reqGcd = gcd[j];
            var totalDigit = n - j - 1;
            for (int d = (ch[j] - '0') + 1; d < 10; d++) {
                String end = fill(reqGcd / gcd(reqGcd, d), totalDigit);
                if (end.length() <= totalDigit) {
                    return num.substring(0, j) + d + end;
                }
            }
        }

        return fill(t, n + 1);

    }

    private String fill(long t, int n) {
        StringBuilder res = new StringBuilder();
        for (int d = 9; d > 1; d--) {
            while (t % d == 0) {
                res.append(d);
                t /= d;
            }
        }
        int req = n - res.length();
        while(req--> 0){
            res.append(1);
        }
        return res.reverse().toString();
    }

    private long gcd(long a, long b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    private boolean invalid(long t) {
        for (var x : new int[] { 2, 3, 5, 7 }) {
            while (t % x == 0) {
                t /= x;
            }
        }
        return t > 1;
    }
}