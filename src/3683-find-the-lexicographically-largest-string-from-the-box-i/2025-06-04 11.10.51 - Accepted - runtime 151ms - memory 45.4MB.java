class Solution {
    public String answerString(String word, int m) {
        int n =word.length();
        int max = n - (m-1);
        if(m==1) return word;
        char maxChar = 'a';
        for(char c : word.toCharArray()){
            if(c > maxChar) maxChar = c;
        }
        
        String result = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<n;i++){
            if(maxChar == word.charAt(i)){
                int j=i;
                while(sb.length() < max && j < n){
                    sb.append(word.charAt(j));
                    j++;
                }
                
                String temp = sb.toString();
 
                 if(temp.compareTo(result) > 0){
                    result = temp;
                }
                sb = new StringBuilder();
            }
        }
        return result;
    }
}