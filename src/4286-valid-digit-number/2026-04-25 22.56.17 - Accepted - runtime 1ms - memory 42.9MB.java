class Solution {
    public boolean validDigit(int n, int x) {
        char ch[] = Integer.toString(n).toCharArray();
        if(ch[0]-'0' == x) return false;
        for(int i=0;i<ch.length;i++){
            if(ch[i] - '0'==x) return true;
        }

        return false;
    }
}