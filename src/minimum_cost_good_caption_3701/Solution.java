package minimum_cost_good_caption_3701;

class Solution {
    Integer dp[][][];
    public String minCostGoodCaption(String caption) {
        
        char ch[] = caption.toCharArray();
        var n = caption.length();
        dp = new Integer[n][5][30];
        if(n <= 2) return "";

        var res = new StringBuilder();
        solve(0, 0, '{', n, ch);
        solve(0, 0, '{', n, ch, res);


        return res.toString();

    }

    private void solve(int i, int cnt, char prev, int n, char ch[], StringBuilder res){
        if( i>=n){
            return;
        }

        int ans = n * 26;
        char r = ' ';
        if(cnt == 3 || i == 0){
            for(char c = 'a';c<='z';c++){
                var num = Math.abs(ch[i] - c) + solve(i+1, c == prev ? 3 : 1, c, n, ch);
                if(num < ans){
                    ans= num;
                    r = c;
                }
            }
        }else{
            r = prev;
            ans = Math.abs(ch[i] -prev) + solve(i+1, cnt + 1,prev, n, ch);
        }

        res.append(r);

        if(prev != r){
            solve(i+1, 1, r, n, ch, res);
        }else{
            solve(i+1, Math.min(3, cnt + 1), r,n, ch, res);
        }
    }

    private int solve(int i, int cnt, char prev, int n, char ch[]){
        if(i >= n){
            if(cnt != 3){
                return n * 26;

            }
            return 0;

        }

        if(dp[i][cnt][prev-'a']!=null) return dp[i][cnt][prev - 'a'];

        var ans = n*26;

        if(cnt == 3 || i ==0){
            for(char c = 'a';c<='z';c++){
                ans = Math.min(ans,
                    Math.abs(ch[i] - c) + solve(i+1, c == prev ? 3 : 1,c, n, ch)
                );
            }
        }else{
            ans = Math.min(ans, 
            Math.abs(ch[i] - prev) + solve(i+1, cnt + 1, prev, n, ch)
            );
        }



        return dp[i][cnt][prev - 'a'] = ans;
    }

}