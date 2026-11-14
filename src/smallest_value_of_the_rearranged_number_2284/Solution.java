package smallest_value_of_the_rearranged_number_2284;

class Solution {
    public long smallestNumber(long num) {
        boolean neg = num < 0;
        if (neg)
            num = -num;

        int cnt[] = new int[10];
        while (num > 0) {
            int dig = (int) (num % 10);
            num /= 10;
            cnt[dig]++;
        }

        if (neg) {
            long ans = 0;
            for (int i = 9; i >= 0; i--) {
                while (cnt[i] > 0) {
                    ans = ans * 10 + i;
                    cnt[i]--;
                }
            }
            return -ans;
        }

        long ans = 0;
        for (int i = 1; i < 10; i++) {
            if (cnt[i] != 0) {
                cnt[i]--;
                ans = ans * 10 + i;
                break;
            }
        }

        while (cnt[0] > 0) {
            cnt[0]--;
            ans = ans * 10;
        }
        for (int i = 1; i < 10; i++) {
            while (cnt[i] > 0) {
                cnt[i]--;
                ans = ans * 10 + i;
            }
        }
        return ans;
    }
}