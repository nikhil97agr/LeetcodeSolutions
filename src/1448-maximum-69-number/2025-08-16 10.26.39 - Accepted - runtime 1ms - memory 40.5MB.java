class Solution {
    public int maximum69Number (int num) {
        char ch[] = (""+num).toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='6'){
                ch[i] = '9';
                break;
            }
        }

        int result = 0;
        for(char c : ch)
    {
        result = result*10 + (int)(c-'0');
    }
    return result;
    }
}