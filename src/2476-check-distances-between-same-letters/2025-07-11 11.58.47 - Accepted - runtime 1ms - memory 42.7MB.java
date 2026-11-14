class Solution {
    public boolean checkDistances(String s, int[] distance) {

        for(char c= 'a'; c<='z';c++){
            int cnt = distance[c-'a'];

            int start = s.indexOf(c);
            if(start !=-1){
                int cn = 0;
                for(int j=start+1;j<s.length();j++){
                    if(s.charAt(j) == c){
                        if(cn!=cnt) return false;
                        cn=0;
                    }else{
                        cn++;
                    }
                }
            }
        }

        return true;
    }
}