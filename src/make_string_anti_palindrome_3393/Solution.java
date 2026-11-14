package make_string_anti_palindrome_3393;

class Solution {
    public String makeAntiPalindrome(String s) {
        int n = s.length();
        int cnt[] = new int[26];
        char res[] = new char[n];
        int max= 0;
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
            max = Math.max(max, cnt[c-'a']);
        }

        if(max > n/2) return "-1";
        int i=0;

        for(char c = 'a';i < n/2 && c<='z';c++){
            while(i < n/2 && cnt[c-'a'] > 0){
                res[i++] = c;
                cnt[c-'a']--;
            }
        }
        if(cnt[res[i-1]-'a'] > 0){
            char next = (char)(res[i-1] + 1);
            char c = res[i-1];
            int ind = i-1;
            for(;res[ind] == c;next++){
                while(cnt[next-'a'] > 0 && res[ind] == c){
                    cnt[next-'a']--;
                    res[i++] = next;
                    ind--;
                }
            }

        }

        for(char c = 'a';c<='z';c++){
            while(cnt[c-'a'] > 0){
                res[i++] = c;
                cnt[c-'a']--;
            }
        }

        return new String(res);
    }
}