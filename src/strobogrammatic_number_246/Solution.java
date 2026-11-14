package strobogrammatic_number_246;

class Solution {
    public boolean isStrobogrammatic(String num) {
        int n = num.length();
        for(int i=0;i<num.length();i++){
            char ch = num.charAt(i);
            char last = num.charAt(n-1-i);
            
            switch(ch){
                case '9' : {
                    if(last!='6' ) return false;
                    else break;
                }

                case '6' : {
                    if(last!='9' ) return false;
                    else break;
                }

                case '8' : {
                    if(last!='8') return false;
                    else break;
                } 
                case '1':{
                    if(last !='1') return false;
                    else break;
                }
                case '0':{
                    if(last !='0') return false;
                    else break;
                }
                default: return false;

            }
        }
        return true;
    }
}