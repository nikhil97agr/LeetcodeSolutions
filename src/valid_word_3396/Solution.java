package valid_word_3396;

class Solution {
    public boolean isValid(String word) {
        if(word.length() < 3) return false;
        boolean v = false;
        boolean con = false;
        boolean dig = false;
        
        for(char c : word.toCharArray()){
            if((c >= 'a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')){
                if((c >= 'a' && c <= 'z') || (c >= 'A' && c <='Z')){
                switch(c){
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        v = true;
                        break;
                    default:
                        con = true;
                }
            }
            }else{
                return false;
            }
            
        }
        return con && v;
    }
}