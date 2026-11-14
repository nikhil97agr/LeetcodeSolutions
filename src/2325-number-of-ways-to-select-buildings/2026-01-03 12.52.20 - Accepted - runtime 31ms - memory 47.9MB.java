class Solution {
    public long numberOfWays(String s) {
        long ans = 0;
        long sum = 0;
        int cnt = 0;
        boolean first = false;
        for(char c : s.toCharArray()){
            if(c== '0'){
                ans += sum;
                cnt++;
                first = true;
            }else{
                if(first)
                    sum+=cnt;
            }
        }
        first = false;
        cnt = 0;
        sum = 0;
        for(char c : s.toCharArray()){
            if(c == '1'){
                ans += sum;
                cnt++;
                first = true;
            }else{
                if(first)
                    sum+=cnt;
            }
        }

        return ans;
    }
}