package lexicographically_smallest_palindrome_2816;

class Solution {
    public String makeSmallestPalindrome(String s) {
        char ch[] = s.toCharArray();
        int start = 0;
        int end =ch.length-1;
        while(start < end){
            char min = (char)Math.min(ch[start], ch[end]);
            ch[start] = ch[end] = min;
            start++;
            end--;
        }
        return new String(ch);
    }
}