package find_the_punishment_number_of_an_integer_2802;

class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int sq = i * i;
            String s = "" + sq;
            if (possible(i, s, 0, 0)) {
                ans += sq;
            }
        }
        return ans;
    }

    private boolean possible(int sum, String s, int i, int curr) {
        if (i == s.length()) {
            if (sum - curr == 0)
                return true;
            return false;
        }
        if (sum < 0)
            return false;

        int dig = s.charAt(i) - '0';

        return possible(sum - curr, s, i + 1, dig) || possible(sum, s, i + 1, curr * 10 + dig);
    }
}