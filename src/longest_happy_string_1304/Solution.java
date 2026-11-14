package longest_happy_string_1304;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        int total = a + b + c;
        int cnta=0, cntb=0, cntc=0;
        while(total-- > 0){
            int max = Math.max(a, Math.max(b, c));

            if((max == a && cnta !=2) || (a > 0 && (cntb == 2 || cntc == 2))){
                res.append('a');
                a--;
                cnta++;
                cntb = cntc = 0;
            }else if ((max == b && cntb!=2) || (b > 0 && (cnta == 2 || cntc == 2))){
                res.append('b');
                b--;
                cntb++;
                cnta = cntc = 0;
            }else if((max == c && cntc !=2) || (c> 0 && (cntb == 2 || cnta == 2))){
                res.append('c');
                c--;
                cntc++;
                cntb = cnta = 0;
            }else{
                break;
            }
        }

        return res.toString();
    }
}