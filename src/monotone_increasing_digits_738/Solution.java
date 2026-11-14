package monotone_increasing_digits_738;

class Solution {
    public int monotoneIncreasingDigits(int n) {
        char ch[] = Integer.toString(n).toCharArray();
        int len = ch.length;
        for(int i=len - 2 ;i>=0;i--){
            if(ch[i] > ch[i+1]){
                ch[i] =(char) (ch[i] - 1);;
                for(int j=i +1;j <len;j++){
                    ch[j] = '9';
                }
            }
        }

        return Integer.parseInt(new String(ch));
    }
}