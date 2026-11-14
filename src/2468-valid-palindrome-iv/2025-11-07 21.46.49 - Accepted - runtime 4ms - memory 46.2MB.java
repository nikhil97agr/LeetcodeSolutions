class Solution {
    public boolean makePalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        int cnt = 0;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) cnt++;
            start++;
            end--;
        }

        return cnt<=2;
    }
}