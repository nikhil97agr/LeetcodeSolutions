class Solution {
    public boolean checkZeroOnes(String s) {
        int one = 0;
        int zero = 0;
        char prev = s.charAt(0);
        int c = 0;
        for(char ch : s.toCharArray()){
            if(ch == prev){
                c++;
            }else{

                if(prev == '1'){
                    one = Math.max(one, c);
                }else{
                    zero = Math.max(zero, c);
                }
                prev = ch;
                c=1;

            }
        }
        if(prev == '0'){
            zero = Math.max(zero, c);
        }else{
            one = Math.max(one, c);
        }

        return one > zero;
    }
}