package minimum_number_of_frogs_croaking_1534;

class Solution {
    String str = "croak";
    public int minNumberOfFrogs(String s) {
        int cnt[] = new int[26];
        int ans = 0;

        for(char c : s.toCharArray()){
            if(!isValid(cnt, c)){
                return -1;
            }else{
                ans = Math.max(ans, cnt['c'-'a']);
                if(c=='k'){
                    for(char ch : str.toCharArray()){
                        cnt[ch-'a']--;
                    }
                }
            }

        }
        for(int x : cnt){
            if(x!=0){
                 return -1;
            }
        }
        return ans;
    }

    private boolean isValid(int cnt[], char c){
        int i=0;
        int next = cnt[c-'a'] + 1;
        while( str.charAt(i) != c && cnt[str.charAt(i) - 'a'] >= next) i++;

        if(str.charAt(i) ==c){
            cnt[c-'a']++;
            return true;
        }

        return false;
    }
}