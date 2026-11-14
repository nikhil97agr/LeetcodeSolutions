class Solution {
    public int minimumChairs(String s) {
        int cnt = 0;
        int ans = 0;
        for(char c : s.toCharArray()){
            if(c == 'E') cnt++;
            else cnt--;

            ans= Math.max(ans, cnt);
        }
        return ans;
    }
}