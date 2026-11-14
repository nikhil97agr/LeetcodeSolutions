class Solution {
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int i=0;
        while(i<n){
            if(i+2<n && s.charAt(i+2)=='#'){
                int digit = Integer.valueOf(s.substring(i,i+2));
                i+=3;
                char c = (char)((int)'a' + (digit-1));
                result.append(c);
            }else{
                int digit = Integer.valueOf(s.substring(i,i+1));
                i++;

                char c = (char)((int)'a' + (digit-1));
                result.append(c);
            }
        }

        return String.valueOf(result);
    }
}