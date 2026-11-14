class Solution {
    public int minimumPartition(String s, int k) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int dig = s.charAt(i) - '0';

            if (dig > k)
                return -1;
        }

        long num = 0;
        int ans = 0;
        int end = 0;
        while (end < n) {
            num = 0;
            ans++;

            int next = s.charAt(end) - '0';
            while (end < n && (num * 10 + next) <= 1l * k) {
                num = num * 10 + next;
                end++;
                if(end < n)
                next = s.charAt(end) - '0';

            }
        }

        return ans;
    }
}