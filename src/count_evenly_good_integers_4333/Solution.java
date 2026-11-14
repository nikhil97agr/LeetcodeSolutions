package count_evenly_good_integers_4333;

class Solution {
    public long countEvenlyGoodIntegers(long l, long r) {
        char c1[] = Long.toString(l - 1).toCharArray();
        char c2[] = Long.toString(r).toCharArray();

        int n = c1.length;
        int m = c2.length;

        return solve(c2, 0, 0, 1, 0, new Long[m][2][2][2], m) - solve(c1, 0, 0, 1, 0, new Long[n][2][2][2], n);
    }

    private long solve(char num[], int i, int cnt, int flag, int start, Long dp[][][][], int n){

            if(i == n){
                if(cnt == 0){
                    return 1;
                }
                return 0;
            }

            if(dp[i][cnt][flag][start]!=null){
                return dp[i][cnt][flag][start];
            }

            long ans = 0;

            int dig = num[i] - '0';
            for(int d=0;d <= 9;d++){
                if(flag == 1 && d > dig){
                    break;
                }
                int newFlag = flag == 1 && d==dig ? 1 : 0;

                if(start == 0){
                    if(d == 0){
                        ans += solve(num, i + 1, cnt, newFlag, start, dp, n);
                    }else{
                        ans += solve(num, i + 1, (cnt + (1 - d%2))%2, newFlag, 1, dp, n);
                    }
                }else{
                    ans += solve(num, i + 1, (cnt + (1 - d%2))%2, newFlag, 1, dp, n);
                }
            }


            return dp[i][cnt][flag][start] = ans;

    }
}