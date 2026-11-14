package numbers_with_repeated_digits_1057;

class Solution {
    public int numDupDigitsAtMostN(int n) {
        char digit[] = Long.toString(n).toCharArray();
        int len = digit.length;
        Integer dp[][][][] = new Integer[len][2][len][1025];
        return solve(0,1, 0, 0, len, digit, dp);
    }


    private int solve(int ind, int flag, int cnt, int state, int len, char digit[], Integer dp[][][][]){
        if(ind==len){
            return cnt ==0 ? 0 : 1;
        }

        if(dp[ind][flag][cnt][state]!=null) return dp[ind][flag][cnt][state];


        int dig = digit[ind] - '0';

        if(flag ==0 ){
            int ans = 0;
            for(int i=0;i<=9;i++){

                if(i==0 && state ==0) {
                    ans += solve(ind + 1, 0, cnt, state, len ,digit, dp);
                    continue;
                }
                if((state & (1<<i))!=0){
                    ans += solve(ind+1, flag, cnt+1, state, len, digit, dp);
                }else{
                    ans += solve(ind+1, flag, cnt, state | (1<<i), len, digit, dp);
                }
            }

            return dp[ind][flag][cnt][state] =ans;
        }else{
            int ans = 0;

            for(int i=0;i<dig;i++){

                if(i==0 && state ==0){
                    ans += solve(ind+1, 0, cnt, state, len, digit, dp);
                    continue;
                }
                if((state & (1<<i))!=0){
                    ans += solve(ind+1, 0, cnt+1, state, len, digit, dp);
                }else{
                    ans += solve(ind+1, 0, cnt, state | (1<<i), len, digit, dp);
                }
            }

            if((state & (1<<dig))!=0){
                ans += solve(ind + 1, 1, cnt + 1, state, len , digit, dp);
            }else{
                ans += solve(ind + 1, 1, cnt , state | (1<<dig), len , digit, dp);
            }

            return dp[ind][flag][cnt][state] = ans;
        }
    }
}