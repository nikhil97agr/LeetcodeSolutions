class Solution {

    public int minStartingIndex(String s, String pattern) {

        int n = s.length();
        int m = pattern.length();

        int zPre[] = z((pattern + s).toCharArray(), m + n);
        int zSuff[] = z(new StringBuilder(s + pattern).reverse().toString().toCharArray(), m + n);

        for (int i = 0; i <= n - m; i++) {
            if(zPre[i + m] + 1 + zSuff[n -i] >= m) return i;
        }
        
        return -1;
    }

    private int[] z(char ch[], int n) {

        int z[] = new int[n];
        int left = 0;
        int right = 0;
        for (int i = 1; i < n; i++) {
            if (i > right) {
                left = right = i;
                while (right < n && ch[right] == ch[right - left]) {
                    right++;
                }

                z[i] = right - left;
                right--;
            } else {
                int k = i - left;
                if (z[k] < right - i + 1) {
                    z[i] = z[k];
                } else {
                    left = i;
                    while (right < n && ch[right] == ch[right - left]) {
                        right++;
                    }
                    z[i] = right - left;
                    right--;
                }
            }
        }
        return z;

    }
}