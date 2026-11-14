class Solution {
    public String maximumXor(String s, String t) {
        int one = 0;
        int zero = 0;
        for(char c : t.toCharArray()){
            if(c == '1') one++;
            else zero++;
        }
        StringBuilder res = new StringBuilder();
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '0'){
                if(one !=0){
                    res.append(1);
                    one--;
                }else{
                    zero--;
                    res.append(0);
                }
            }else{
                if(zero != 0){
                    zero--;
                    res.append(1);
                }else{
                    one--;
                    res.append(0);
                }
            }
        }

       return res.toString();
    }

    
}