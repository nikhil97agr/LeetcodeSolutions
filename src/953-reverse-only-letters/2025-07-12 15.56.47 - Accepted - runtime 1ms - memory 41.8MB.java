class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        int i =0;
        char res[] =new char[s.length()];
        
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                sb.append(c);
            }
        }
        
        sb.reverse();
        
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                res[i] = sb.charAt(ind);
                ind++;
            }else{
                res[i] = c;
            }
            i++;
        }
        
        return new String(res);
    }
}