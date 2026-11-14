package minimum_number_of_swaps_to_make_the_binary_string_alternating_1994;

class Solution {
    public int minSwaps(String s) {
        int one = 0;
        int zero = 0;
        for(char c : s.toCharArray()){
            if (c =='1') one++;
            else zero++;
        }

        if(Math.abs(one - zero) > 1) return -1;
        int n = s.length();
        char ch[] = s.toCharArray();
        if(one > zero){
            return steps(ch, generate(n, '1'), n);
        }else if(zero > one){
            return steps(ch, generate(n, '0'), n);
        }else{
            return Math.min(
                steps(ch, generate(n, '0'), n),
                steps(ch, generate(n, '1'), n)
            );
        }
    }
    private char[] generate(int n, char start){
        char ch[] =new char[n];
        int i=0;
        while(i < n){
            ch[i++] = start;
            start = start == '0' ? '1' : '0';
        }

        return ch;
    }

    private int steps(char ch[], char req[], int n){
        int pos = 0;
        for(int i=0;i<n;i++){
            if(ch[i] != req[i]){
                pos++;
            }
        }

        return pos / 2;
    }

}