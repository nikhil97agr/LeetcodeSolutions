class Solution {
    public int numberOfSpecialSubstrings(String s) {
      int ans = 0;
      int start = 0;
      int end = 0;

        int cnt [] = new int[26];
        int n = s.length();
        while(end < n){
            char c = s.charAt(end);
            if(cnt[c-'a']!=0){

                ans += getCnt(start, end);
                while(s.charAt(start)!=c){
                    cnt[s.charAt(start)-'a']--;
                    start++;
                }

                start++;

                ans -= getCnt(start, end);
            }else{
                cnt[c-'a']++;
            }
            end++;
        }
        ans += getCnt(start, end);

        return ans;
    }

    private int getCnt(int start, int end){
        int len = end - start;
        return (len*(len+1))>>1;
    }
}