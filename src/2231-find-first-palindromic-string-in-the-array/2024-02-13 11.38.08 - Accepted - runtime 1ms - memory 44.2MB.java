class Solution {
    public String firstPalindrome(String[] words) {
        for(String s : words){
            if(pal(s)){
                return s;
            }
        }
        return "";
    }

    private boolean pal(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}