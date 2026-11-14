class Solution {
    public int maxDiff(int num) {
        char ch[] = String.valueOf(num).toCharArray();
        int i=0;
        while(i <ch.length && ch[i] == '9') i++;
        if(i!=ch.length)
        {
            char dig = ch[i];
            while(i<ch.length){
                if(ch[i] == dig){
                    ch[i] = '9';
                }
                i++;
            }
        }
        int max = Integer.parseInt(String.valueOf(ch));
        i=0;
        ch = String.valueOf(num).toCharArray();
        while(i < ch.length && (ch[i] == '1' || ch[i] == '0'))i++;

        if(i != ch.length){
            if(ch[0] == '1'){
                char dig = ch[i];
                while( i< ch.length){
                    if(ch[i] == dig){
                        ch[i] = '0';
                    }
                    i++;
                }
            }else{
                char dig = ch[i];
                while(i < ch.length){
                    if(ch[i] == dig){
                        ch[i] = '1';
                    }
                    i++;
                }
            }
        }
        int min = Integer.parseInt(String.valueOf(ch));
        return max - min;

    }
}