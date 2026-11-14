class Solution {
    public String sortString(String s) {
        int cnt[] = new int[26];

        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while(sb.length() != s.length()){
            for(char c = 'a';c<='z';c++){
                if(cnt[c-'a']!=0){
                    sb.append(c);
                    cnt[c-'a']--;
                }

            
            }

            for(char c = 'z';c>='a';c--){
                if(cnt[c-'a']!=0){
                    sb.append(c);
                    cnt[c-'a']--;
                }
            }
            
        }
        return sb.toString();
    }
}