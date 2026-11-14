package number_of_substrings_with_only_1s_1636;

class Solution {
    public int numSub(String s) {
        int ans =0;
        int cnt = 0;

        for(char c : s.toCharArray()){
            if(c== '0'){
                int prod = prod(cnt, cnt+1)/2;

                ans = sum(ans, prod);
                cnt=0;
            }else{
                cnt++;
            }
        }

        int prod = prod(cnt, cnt+1)/2;
        ans = sum(ans, prod);
        return ans;
    }

    int sum(long a, long b){
        long mod = (long)1e9 + 7;

        return (int)((a+b)%mod);
    }

    int prod(long a, long b){
        long mod = (long)1e9+7;
        return (int)((a*b)%mod);
    }
}