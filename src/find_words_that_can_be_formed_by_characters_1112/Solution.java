package find_words_that_can_be_formed_by_characters_1112;

class Solution {
    public int countCharacters(String[] words, String chars) {
        int cnt[] = new int[26];
        int res = 0;
        for(char c : chars.toCharArray()){
            cnt[c-'a']++;
        }
        for(String s : words){
            int cn[] = new int[26];
            for(char c :s.toCharArray()){
                cn[c-'a']++;
            }

            boolean ans = true;
            for(int i=0;i<26;i++){
                if(cnt[i]<cn[i]){
                    ans= false;
                    break;
                }
            }
            if(ans){
                res += s.length();
            }
        }
        return res;
    }
}