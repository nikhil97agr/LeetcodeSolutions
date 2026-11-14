class Solution {
    public int compress(char[] chars) {
        int count = 0;
        int n = chars.length;
        if(n==1){
            return n;
        }
        int ind = 0;
        for(int i=1;i<n;i++){
            if(chars[i]==chars[i-1]){
                count++;
            }else{
                if(count==0){
                    chars[ind++] = chars[i-1];
                }else{
                    chars[ind++] = chars[i-1];
                    String temp = ""+(count+1);
                    for(char c : temp.toCharArray()){
                        chars[ind++] = c;
                    }
                }
                count = 0;
            }
        }

        if(count==0){
            chars[ind++] = chars[n-1];
        }else{
            chars[ind++] = chars[n-1];
            String temp = ""+(count+1);
                    for(char c : temp.toCharArray()){
                        chars[ind++] = c;
                        
                    }
        }
        return ind;
    }
}