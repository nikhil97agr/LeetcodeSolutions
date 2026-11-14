class Solution {
    public String compressedString(String word) {
        StringBuilder result = new StringBuilder();
        char prev = word.charAt(0);
        int cnt = 0;
        int i=0;
        while(i< word.length()){
            if(word.charAt(i) == prev){
                if(cnt == 9){
                    result.append(""+cnt+prev);
                    cnt = 1;
                }else{
                    cnt++;
                }
            }else{
                result.append(""+cnt+prev);
                prev = word.charAt(i);
                cnt = 1;
            }
            i++;
        }
        
        result.append(""+cnt+prev);
        
        return result.toString();
    }
}