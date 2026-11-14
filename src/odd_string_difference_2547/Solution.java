package odd_string_difference_2547;

class Solution {
    public String oddString(String[] words) {
        int n = words.length;
        int m =  words[0].length();
        int diff[][] = new int[n][m-1];
        for(int j = 0;j<n;j++){
            String s = words[j];
            for(int i=0;i<m-1;i++){
                diff[j][i] = s.charAt(i+1)-s.charAt(i);
            }
        }
        for(int i=0;i<m-1;i++){
            int x = diff[0][i];
            String result = "";
            int count = 0;
            for(int j=1;j<n;j++){
                if(diff[j][i]!=x){
                    result =  words[j];
                    count++;
                }
            }
            if(count==1){
                return result;
            }
            if(count>1){
                return words[0];
            }
        }
        return "";
        
    }
}