class Solution {
    public String reverseByType(String s) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)) s1.append(c);
            else s2.append(c);
        }
        s1.reverse();
        s2.reverse();
        char res[] = new char[s.length()];
        int i1 = 0;
        int i2 = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)){
                res[i] = s1.charAt(i1);
                i1++;
            }else{
                res[i] = s2.charAt(i2);
                i2++;
            }
        }
        return new String(res);
    }
}