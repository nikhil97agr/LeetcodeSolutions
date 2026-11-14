package minimum_operations_to_make_a_rotated_palindrome_i_4350;

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int ans = 1_000_000_000;
        char ch[] = s.toCharArray();
        int rotate = 0;
        do {

            int cnt = 0;
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                if (ch[i] != ch[j]) {
                    int i1 = ch[i] - 'a';
                    int i2 = ch[j] - 'a';
                    int min = Math.min(i1, i2);
                    int max = Math.max(i2, i1);
                    cnt += Math.min(max - min, 26 - max + min);
                }
            }
            ans = Math.min(ans, rotate + cnt);

            rotate++;
            char temp = ch[0];
            int i = 0;
            int j = 1;
            while (j < n) {
                ch[i] = ch[j];
                i++;
                j++;
            }
            ch[n - 1] = temp;

        } while (rotate < n);

        return ans;
    }
}