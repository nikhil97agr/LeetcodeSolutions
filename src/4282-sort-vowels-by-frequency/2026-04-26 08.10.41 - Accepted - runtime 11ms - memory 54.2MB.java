import java.util.Arrays;
import java.util.LinkedList;

class Solution {

    public String sortVowels(String s) {

        char ch[] = s.toCharArray();
        var que = new LinkedList<Integer>();
        int n = ch.length;
        int ind[] = new int[26];
        Arrays.fill(ind, -1);
        int cnt[] = new int[26];
        for (int i = 0; i < n; i++) {
            if (vow(ch[i])) {
                que.offer(i);
                cnt[ch[i] - 'a']++;
                int in = ch[i] - 'a';
                if (ind[in] == -1) {
                    ind[in] = i;
                }
            }
        }
        while (!que.isEmpty()) {
            int max = 0;
            char c = 'a';
            int prev = n + 1;
            for (char i = 'a'; i <= 'z'; i++) {
                if (cnt[i - 'a'] > 0) {
                    if (cnt[i - 'a'] > max) {
                        max = cnt[i - 'a'];
                        c = i;
                        prev = ind[i - 'a'];
                    } else if (cnt[i - 'a'] == max && ind[i - 'a'] < prev) {
                        prev = ind[i - 'a'];
                        c = i;
                    }
                }
            }

            while (cnt[c - 'a'] > 0) {
                cnt[c - 'a']--;
                ch[que.poll()] = c;
            }
        }

        return new String(ch);
    }

    private boolean vow(char c) {

        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}