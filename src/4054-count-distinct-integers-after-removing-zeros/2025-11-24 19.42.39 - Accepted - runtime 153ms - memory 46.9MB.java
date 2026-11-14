class Solution {
    public long countDistinct(long n) {
        long res = solve(0, 0, 0,1, new Long[16][16][16][2], Long.toString(n).toCharArray());

        return n - res;
    }


    private long solve(int i,int other, int cnt, int flag, Long dp[][][][], char ch[]){
        if(i == ch.length){
            if(cnt >= 1 && other >= 1) return 1;
            return 0;
        }

        if(dp[i][other][cnt][flag] !=null) return dp[i][other][cnt][flag];

        long ans= 0;
        

        if(flag == 0){
            for(int dig =0; dig <=9;dig++){
                if(dig ==0 && other ==0 ){
                    ans += solve(i+1, other, cnt, flag, dp, ch);
                }else{
                    if(dig ==0){
                        ans += solve(i+1, other, cnt+1, flag, dp, ch);
                    }else{
                        ans += solve(i+1, other+1, cnt, flag, dp, ch);
                    }
                }
            }
        }else{
            int d = ch[i] - '0';
            for(int dig = 0;dig<d;dig++){
                if(other ==0 && dig ==0){
                    ans += solve(i+1, other, cnt, 0, dp, ch);
                }else{
                    if(dig ==0){
                        ans += solve(i+1, other, cnt+1, 0, dp, ch);
                    }else{
                        ans += solve(i+1,other+1, cnt, 0, dp, ch);
                    }
                }
            }

            if(d==0 && other ==0){
                ans += solve(i+1, other, cnt, 1, dp, ch);
            }else{
                if(d==0){
                    ans += solve(i+1, other, cnt+1, 1, dp, ch);
                }else{
                    ans += solve(i+1, other+1, cnt, 1, dp, ch);
                }
            }
        }

        return dp[i][other][cnt][flag] = ans;


    }
}