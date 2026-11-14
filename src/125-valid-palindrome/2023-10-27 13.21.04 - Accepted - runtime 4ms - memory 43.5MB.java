class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                if(Character.isUpperCase(c)){
                    c = Character.toLowerCase(c);
                }
                sb.append(c);
            }
        }
        StringBuilder sb2 = new StringBuilder(sb.toString());
        sb2.reverse();

        return sb.toString().equals(sb2.toString());
    }
}