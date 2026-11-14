class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length() <= 2) return 0;
        int ans =0;
        for(int i=0;i<s.length()-2;i++){
            char c = s.charAt(i);
            if(c != s.charAt(i+1) && c != s.charAt(i+2) && s.charAt(i+1) != s.charAt(i+2)) ans++;
        }
        return ans;
    }
}