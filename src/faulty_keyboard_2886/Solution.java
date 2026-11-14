package faulty_keyboard_2886;

class Solution {
    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c== 'i'){
                sb.reverse();
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}