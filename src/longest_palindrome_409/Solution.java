package longest_palindrome_409;

class Solution {
    public int longestPalindrome(String s) {
        int cnt[] = new int[256];
        for(char c : s.toCharArray()){
            cnt[c]++;
        }

        int result = 0;
        boolean odd = false;
        for(int i=0;i<256;i++){
            result += cnt[i]/2;
            if(cnt[i]%2==1){
                odd = true;
            }
        }
        result += result;
        return odd ? result+1 : result;
    }
}