package minimum_operations_to_make_every_element_palindromic_4344;

import java.util.*;
class Solution {
    static List<Long> even = new ArrayList<>();
    static List<Long> odd = new ArrayList<>();

    {
        if (even.isEmpty()) {
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= 10; i++) {

                generate(sb, 0, i - 1, i);
            }
        }

    }

    public long minOperations(int[] nums) {

        long ans = 0;

        for (int x : nums) {
            ans += compute(x, x % 2 == 0 ? even : odd);
        }

        return ans / 2;
    }

    private long compute(long x, List<Long> list) {


        int start = 0;
        int end = list.size() - 1;
        int ind = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (list.get(mid) <= x) {
                ind = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        long lower = list.get(ind);
        long higher = list.get(ind + 1);


        return Math.min(x - lower, higher - x);


    }

    private void generate(StringBuilder sb, int start, int end, int len) {

        if (end < start) {
            StringBuilder ss = new StringBuilder(sb);
            ss.reverse();
            String a = sb.toString() + (len % 2 == 0 ? ss.toString() : ss.substring(1));

            long num = Long.parseLong(a);
            if (num % 2 == 0)
                even.add(num);
            else
                odd.add(num);
            return;
        }

        if (start == 0) {
            for (char i = '1'; i <= '9'; i++) {
                sb.append(i);
                generate(sb, start + 1, end - 1, len);
                sb.setLength(sb.length() - 1);
            }
        } else {
            for (char i = '0'; i <= '9'; i++) {
                sb.append(i);
                generate(sb, start + 1, end - 1, len);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}