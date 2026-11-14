class Solution {
    public int maxRepOpt1(String text) {
        int cnt1[] = new int[26];
        int ans = 0;
        int cnt2[] = new int[26];
        for (char c : text.toCharArray()) {
            cnt1[c - 'a']++;
        }
        int n = text.length();
        for (int i = 0, j = 0; i < n; i++) {
            char c = text.charAt(i);
            cnt2[c - 'a']++;
            cnt1[c - 'a']--;
            while (duplicate(cnt2) || distinct(cnt2) > 2) {
                c = text.charAt(j);
                cnt2[c - 'a']--;
                cnt1[c - 'a']++;
                j++;
            }
            int len = i -j + 1;
            c = text.charAt(i);
            if (cnt2[c - 'a'] == len) {
                ans = Math.max(len, ans);
            } else {
                for(c = 'a';c<='z';c++){
                    if(cnt1[c-'a']  !=0 && cnt2[c-'a'] == len-1){
                        ans = Math.max(ans, len);
                        break;
                    }
                }
            }

        }
        return ans;

    }

    private int distinct(int cnt[]){
        int c = 0;
        for(int x : cnt){
            if( x > 0) c++;
        }

        return c;
    }

    private boolean duplicate(int cnt[]) {
        boolean found = false;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 1) {
                if (found)
                    return true;
                found = true;
            }
        }
        return false;
    }
}