class Solution {
    public int minChanges(String s) {
        int ans = 0;
        char prev = s.charAt(0);
        int cnt = 0;
        for(char c : s.toCharArray()){
            if(c == prev){
                cnt++;
            }else{
                if(cnt%2!=0){
                    cnt = 0;
                    ans++;
                    prev = c;
                }else{
                    cnt = 1;
                    prev = c;
                }
            }
        }
        return ans;
    }
}