package minimum_number_of_flips_to_reverse_binary_string_4126;

class Solution {
    public int minimumFlips(int n) {
        char ch[] = Integer.toBinaryString(n).toCharArray();
        int s = 0;
        int e = ch.length-1;
        int cnt = 0;
        while( s < e){
            if(ch[s] != ch[e]){
                cnt+=2;

            }
            s++;
            e--;
        }

        return cnt;
    }

}