class Solution {
    public int removePalindromeSub(String s) {
        int n = s.length();
        boolean res = true;
        for(int i=0;i<n/2;i++){
            if(s.charAt(i) != s.charAt(n-1-i)){
                res = false;
                break;
            }
        }

        return res ? 1 : 2;
    }
}