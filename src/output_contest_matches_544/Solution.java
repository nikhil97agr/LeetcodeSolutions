package output_contest_matches_544;

class Solution {
    public String findContestMatch(int n) {
        String str[] = new String[n];

        for(int i=1;i<=n;i++){
            str[i-1] = Integer.toString(i);
        }

        for(;n > 1; n >>= 1){
            for(int i=0;i<n;i++){
                str[i] = "(" + str[i] +","+str[n-1-i]+")";
            }
        }
        return str[0];
    }
}