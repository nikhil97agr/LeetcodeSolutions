class Solution {
    public String modifyString(String s) {
        char ch[] = s.toCharArray();

        for(int i=0;i<ch.length;i++){
            if(ch[i] == '?'){
                char prev = ' ';
                char next = ' ';
                if(i > 0){
                    prev = ch[i-1];
                }

                if(i < ch.length-1){
                    next = ch[i+1];
                }

                if(prev != 'a' && next != 'a'){
                    ch[i] = 'a';
                }else if(prev == 'a' && next == 'a'){
                    ch[i] = 'b';
                }else if(prev == 'a'){
                    if(next == 'b') ch[i] = 'c';
                    else ch[i]= 'b';
                }else{
                    if(prev == 'b') ch[i] = 'c';
                    else ch[i] = 'b';
                }
            }
        }

        return new String(ch);
    }
}