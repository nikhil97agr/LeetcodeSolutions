class Solution {
    public String filterCharacters(String s, int k) {
        int cnt[] = new int [26];
        for(char c : s.toCharArray()) cnt[c-'a']++;

        for(char c= 'a';c<='z';c++){
            if(cnt[c-'a'] >= k) s = s.replace(c, ' ');
        }
        StringBuilder res = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c != ' ') res.append(c);

        }

        return res.toString();
        
    }
}