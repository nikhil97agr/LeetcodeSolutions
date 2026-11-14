package minimum_flips_to_make_binary_string_coherent_4131;

class Solution {
    public int minFlips(String s) {
        char ch[] = s.toCharArray();
        int n = ch.length;
        int one = 0;
        for(char c : ch){
            if(c=='1') one++;
        }
        int zero =n - one;
        if(one <= 1 || zero ==0 ) return 0;
        int ans = Math.min(one, zero);
        if(one > 0){
            ans = Math.min(ans, one - 1);
        }

        if(n >= 2){
            int cnt = 0;
            for(int i=1;i<n-1;i++){
                cnt += (ch[i] - '0');
            }

            int total = cnt + (ch[0] == '0' ? 1 : 0) + (ch[n-1] == '0' ? 1 : 0);
            ans = Math.min(ans, total);
        }

        return ans;
    }
}