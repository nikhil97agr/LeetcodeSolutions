class Solution {
    public int longestPalindrome(String s, String t) {
        int n =s.length();
        int m = t.length();
        int ans = 0;
        for(int slen = 0;slen<=n;slen++){
            int sstart = 0;
            int send = slen;

            while(send <= n ){
                String ssub = s.substring(sstart, send);
                sstart++;
                send++;

                for(int tlen = 0;tlen <= m;tlen++){
                    int tstart = 0;
                    int tend = tlen;
                    while(tend <= m){
                        String tsub = t.substring(tstart, tend);
                        tstart++;
                        tend++;

                        if(check(ssub + tsub)){
                            ans = Math.max(ans, ssub.length() + tsub.length());
                        }
                    }
                }
            }
        }

        return ans;
    }

    private boolean check(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}