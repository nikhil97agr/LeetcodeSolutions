package largest_number_after_mutating_substring_2077;

class Solution {
    public String maximumNumber(String num, int[] change) {
        char ch[] = num.toCharArray();
        int n = num.length();
        int start = 0;

        while (start < n) {
            int dig = ch[start] - '0';

            if (dig < change[dig]) {
                while (start < n) {
                    dig = ch[start] - '0';
                    if (dig <= change[dig]) {
                        ch[start] = (char) ('0' + change[dig]);
                    } else {
                        break;
                    }
                    start++;
                }

                break;
            }
            start++;
        }
        return new String(ch);

    }
}