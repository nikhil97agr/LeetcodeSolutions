class Solution {
    public String largestPalindromic(String num) {
        int cnt[] = new int[10];
        for (char c : num.toCharArray()) {
            cnt[c - '0']++;
        }
        int odd = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (cnt[i] != 0) {
                if (cnt[i] % 2 == 1) {
                    if (odd == -1)
                        odd = i;
                }
                while (cnt[i] > 1) {
                    sb.append(i);
                    cnt[i] -= 2;
                }
            }
        }
        String res = sb.toString();
        sb.reverse();
        res = res + (odd == -1 ? "" : odd) + sb.toString();

        char arr[] = res.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while (start < end && arr[start] == '0') {
            start++;
            end--;
        }
        StringBuilder ans = new StringBuilder();
        while(start <= end){
            ans.append(arr[start]);
            start++;
        }
        if(ans.length() == 0) return "0";
        return ans.toString();

    }
}