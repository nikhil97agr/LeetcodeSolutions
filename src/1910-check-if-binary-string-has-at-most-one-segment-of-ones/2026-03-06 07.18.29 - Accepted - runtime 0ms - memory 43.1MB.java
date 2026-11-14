class Solution {
    public boolean checkOnesSegment(String s) {
        int cnt = 0;
        int cn = 0;
        char prev = s.charAt(0);

        for(char c : s.toCharArray()){
            if(c == prev){
                cn++;
            }else{
                if(prev == '1' ){
                    cnt++;
                }
                cn=1;
                prev = c;
            }


        }

        if(prev == '1') cnt++;
        return cnt<=1;
    }
}