class Solution {
    public int minRotations(String s) {
       int ans = 0;
       int curr = 0;
       for(char c : s.toCharArray()){
        int dig = ( c- '0');
        int a = Math.abs(curr - dig);
        int b = Math.abs(curr + 10 - dig);
        int d = Math.abs(10 - curr + dig);
        curr =dig;
        ans += Math.min(a, Math.min(b,d));
       } 

       return ans;
    }
}