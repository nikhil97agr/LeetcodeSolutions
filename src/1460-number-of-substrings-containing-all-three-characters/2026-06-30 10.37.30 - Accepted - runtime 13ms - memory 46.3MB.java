class Solution {
    public int numberOfSubstrings(String s) {
        int cnt[] = new int[3];

        int ans = 0;
        int n = s.length();
        int start = 0;
        int end = 0;
        while(end < n){
            int c = s.charAt(end) - 'a';
            cnt[c]++;
            if(cnt[0] > 0 && cnt[1] > 0 && cnt[2]> 0){
                c = s.charAt(start) - 'a';
                while(cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0){
                    ans += (n-end);
                    cnt[c]--;
                    start++;
                    c = s.charAt(start) - 'a';
                }
            }
            end++;
        }

        return ans;
    }
}