class Solution {
    public String breakPalindrome(String palindrome) {
        boolean change = false;
        if(palindrome.length()==1){
            return "";
        }
        int n = palindrome.length();
        char ch[] = palindrome.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(n%2==1&&i==n/2){
                continue;
            }
            if(ch[i]!='a'){
                ch[i] = 'a';
                change = true;
                break;
            }
        }
        if(change){
            return String.valueOf(ch);
        }
        ch[n-1] = 'b';
        return String.valueOf(ch);
    }
}