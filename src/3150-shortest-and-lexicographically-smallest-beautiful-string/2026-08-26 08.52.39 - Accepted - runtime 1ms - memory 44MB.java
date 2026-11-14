class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String result = "";
        int n = s.length();
        int cnt =0;
        int i=0;
        int j =0;
        int currLen = Integer.MAX_VALUE;
        while(i<n){
            if(s.charAt(i)=='1'){
                cnt++;
            }
            
            if(cnt ==k){
                while(s.charAt(j)!='1'){
                    j++;
                }
                if(result.length()==0){
                    result = s.substring(j, i+1);
                    currLen = result.length();
                }else if((i-j+1) < currLen){
                    result = s.substring(j, i+1);
                    currLen = result.length();
                }else if( (i-j+1) == currLen &&  result.compareTo(s.substring(j, i+1)) > 0){
                    result = s.substring(j, i+1);
                    currLen = result.length();
                }
                j++;
                cnt--;
            }
            i++;
            
        }
        return result;
    }
}