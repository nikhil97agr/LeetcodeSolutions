class Solution {
    public String majorityFrequencyGroup(String s) {
        int cnt[] = new int[26];

        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }
        String res = new String();
        for(int g = s.length();g>0;g--){
            StringBuilder sb = new StringBuilder();
            for(char c= 'a';c<='z';c++){
                if(cnt[c-'a'] == g){
                    sb.append(c);
                }
            }

            if(sb.length() > res.length()){
                res = sb.toString();
            }
        }

        return res;

        
    }
}