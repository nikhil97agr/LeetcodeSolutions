class Solution {
    public String replaceDigits(String s) {
        StringBuilder res = new StringBuilder();

        for(int i=0;i<s.length();i+=2){
            char c= s.charAt(i);
            if(i==s.length()-1){
                res.append(c);
                break;
            }
            int dig = s.charAt(i+1)-'0';

            res.append(c).append(get(c, dig));
        }

        return res.toString();
    }
    private char get(char c, int dig){
        int diff = 'z'-c;
        if(diff >= dig){
            return (char)(c + dig);
        }else{
            int reminder = dig -= diff;
            return (char)('a' + ((reminder)-1));
        }
    }
}