class Solution {
    public boolean validPalindrome(String s) {
        return check(s, 0, s.length()-1, 1);
    }

    private boolean check(String s, int start, int end, int change){
        if(start== end) return true;

        if(start > end) return true;
        if(s.charAt(start) == s.charAt(end)) return check(s, start+1, end-1, change);

        if(change ==0) return false;

        return check(s, start+1, end, 0) || check(s, start, end - 1, 0);
        
    }
}