class Solution {
    public String maximumBinaryString(String binary) {
        int cnt = 0;
        char ch[] = binary.toCharArray();
        if(ch.length == 1) return new String(ch);
        for(char c : ch) if(c=='0') cnt++;

        StringBuilder res = new StringBuilder();
        for(int i=0;i<ch.length-1;i++){
            if(ch[i] == '1'){
                res.append(1);
            }else{
                cnt--;
                if(cnt == 0){
                    res.append("01");
                    break;
                }
                res.append(1);
                ch[i+1] ='0';
            }
        }
        if(cnt!=0){
            res.append(0);
        }
        while(res.length() != ch.length){
            res.append(1);
        }

        return res.toString();
    }
}