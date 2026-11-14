package count_substrings_that_can_be_rearranged_to_contain_a_string_i_3573;

class Solution {
    public long validSubstringCount(String word1, String word2) {
        int cnt1[] = new int[26];
        for(char c : word2.toCharArray()){
            cnt1[c-'a']++;
        }
        
        long ans = 0;
        
        int start = 0;
        int end = 0;
        int cnt2[] = new int[26];
        int n = word1.length();
        while(end < n){
            char c = word1.charAt(end);
            cnt2[c-'a']++;
            while(same(cnt1, cnt2)){
                ans += (n-end);
                cnt2[word1.charAt(start)-'a']--;
                start++;
            }
            end++;
        }
        
        while(same(cnt1, cnt2)){
            ans ++;
            cnt2[word1.charAt(start)-'a']--;
            start++;
        }
        return ans;
    }
    
    private boolean same(int cnt1[], int cnt2[]){
        for(int i=0;i<26;i++){
            if(cnt2[i] < cnt1[i]) return false;
        }
        return true;
    }
}