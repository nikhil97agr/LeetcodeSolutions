package merge_close_characters_4013;

class Solution {
    public String mergeCharacters(String s, int k) {

        for(int j=0;j<s.length();j++){
            for(int i = j-1;i>=0;i--){
                if(s.charAt(i) == s.charAt(j)){
                    if( j - i <= k){
                        s= s.substring(0, j) + s.substring(j+1);
                        j--;
                    }else{
                        break;
                    }
                }
            }
        }

        return s;
    }
}