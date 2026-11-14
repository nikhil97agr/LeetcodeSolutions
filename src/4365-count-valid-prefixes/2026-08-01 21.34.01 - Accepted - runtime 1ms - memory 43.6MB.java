class Solution {
    public int countValidPrefixes(String s) {
        int ans= 0;
        int one = 0;
        int zero = 0;
        for(char c : s.toCharArray()){
            if(c == '1'){
                one++;
            }else{
                zero++;
            }

            if(Math.abs(one - zero) <= 1){
                ans++;
            }
        }

        return ans;
    }
}