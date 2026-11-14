package minimum_number_of_moves_to_make_palindrome_1356;

class Solution {
    public int minMovesToMakePalindrome(String s) {
        if(s.length() < 2) return 0;
        int n = s.length();
        int start= 0;
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(start <= end && s.charAt(start) != s.charAt(end)){
            sb.append(s.charAt(start));
            start++;
            cnt++;
        }
        
        if(start == end){
            cnt/=2;
        }
        start++;

        while(start < end){
            sb.append(s.charAt(start));
            start++;
        }



        return cnt + minMovesToMakePalindrome(sb.toString());
    }
}