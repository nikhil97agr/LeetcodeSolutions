class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int pos =26 -  (ch-'a');
            ans += pos * (1 + i);
        }
        return ans;
    }
}