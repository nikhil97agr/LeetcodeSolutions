class Solution {
    public int longestContinuousSubstring(String s) {
        int count = 1;
        int result = 1;
        char c = s.charAt(0);
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == c+1){
                count +=1;
                c = ch;
                
                
            }else{
                result = Math.max(count, result);
                count = 1;
                c = ch;
            }
            
        }
        return Math.max(result, count);
        
    }
}