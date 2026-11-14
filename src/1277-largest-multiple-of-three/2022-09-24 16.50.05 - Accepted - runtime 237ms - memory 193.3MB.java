class Solution {
    public String largestMultipleOfThree(int[] digits) {
        
        Arrays.sort(digits);
        char ch[] = new char[digits.length];
        int total = 0;
        int n = digits.length;
        int rem1[] = new int[]{-1,-1};
        int rem2[]=new int[]{-1,-1};
        int zeroCount = 0;
        for(int i=n-1;i>=0;i--){
            total += digits[i];
            ch[n-1-i] = (char)(digits[i]+'0');
            if(digits[i]%3==1){
                if(rem1[0]==-1){
                    rem1[0] =n-1-i;
                }else {
                    rem1[1] = rem1[0];
                    rem1[0] = n-1-i;
                }
            }
            else if(digits[i]%3==2 ){
                if(rem2[0]==-1){
                    rem2[0] = n-1-i;
                }
                else{
                    rem2[1] = rem2[0];
                    rem2[0] = n-1-i;
                }
            }
            if(digits[i]==0){
                zeroCount ++;
            }
        }
        
        if(zeroCount ==n){
            return "0";
        }
        
        if(total%3==0){
            return new String(ch);
        }
        int rem = total%3;
        String result = "";
        zeroCount = 0;
        if(rem==1){
            if(rem1[0]==-1){
               
                ch[rem2[0]] = '-';
                ch[rem2[1]] = '-';
            }else{
                            ch[rem1[0]] = '-';

            }
            for(char c : ch){
                if(c!='-'){
                    result += c;
                }
                if(c=='0'){
                    zeroCount++;
                }
            }
        }
        
        else{
            if(rem2[0]!=-1){
                ch[rem2[0]] = '-';
            }else{
                ch[rem1[0]] = '-';
                ch[rem1[1]] = '-';
            }
            for(char c : ch){
                if(c!='-'){
                    result+=c;
                }
                if(c=='0'){
                    zeroCount++;
                }
            }
        }
        if(result.length()==0){
            return "";
        }
        if(zeroCount==result.length()){
            return "0";
        }
        return result;
        
        
            
    }
    
   
}