class Solution {
    public int countHomogenous(String s) {
        long mod = (long)1e9+7;
        long cnt = 0;
        char prev = ' ';
        long ans = 0;
        for(char c : s.toCharArray()){
            if(c != prev){
                prev = c;
                ans += ((cnt*(cnt+1))/2)%mod;
                ans %=mod;
                cnt = 0;
            }
            cnt++;
        }

        ans += ((cnt*(cnt+1))/2)%mod;

        return (int)(ans%mod);
    }
}