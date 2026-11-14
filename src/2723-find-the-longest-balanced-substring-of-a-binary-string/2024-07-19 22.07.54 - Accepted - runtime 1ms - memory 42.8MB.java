class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int zero = 0;
        int one = 0;
        int ans = 0;

        for(char c : s.toCharArray()){
            if(c=='1'){
                one++;
            }else{
                if(one!=0){
                    ans = Math.max(ans, 2*Math.min(one, zero));
                    one = 0;
                    zero = 1;
                }else{
                    zero++;
                }
            }
        }

        ans = Math.max(ans, 2*Math.min(zero, one));
        return ans;
    }
}