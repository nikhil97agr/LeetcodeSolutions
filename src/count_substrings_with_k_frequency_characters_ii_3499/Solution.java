package count_substrings_with_k_frequency_characters_ii_3499;

class Solution {
    public long numberOfSubstrings(String s, int k) {
        int cnt[] = new int[26];
        long ans = 0;
        int n = s.length();
        int start = 0;
        int end = 0;
        while(end < n){
            char c= s.charAt(end);

            cnt[c-'a']++;

            while(check(cnt, k)){
                ans += (n-end);
                c = s.charAt(start);
                cnt[c-'a']--;
                start++;
            }
            end++;
        }

        return ans;
    }

    private boolean check(int cnt[], int k){

        for(int x : cnt){
            if(x >=k) return true;
        }
        return false;
    }
}