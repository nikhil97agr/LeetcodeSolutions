package valid_parenthesis_string_678;

class Solution {
    Boolean dp[][];
    public boolean checkValidString(String s) {
        int n = s.length();
        dp = new Boolean[n][n];

        return solve(0, 0, s.toCharArray(), n);
    }

    private boolean solve(int cnt, int i, char ch[], int n){
        if(i == n){
            if( cnt == 0) return true;
            return false;
        }
        if(cnt < 0){
            return false;
        }

        if(dp[i][cnt] != null) return dp[i][cnt];

        if(ch[i] == '('){
            return dp[i][cnt] = solve(cnt + 1, i + 1, ch, n);
        }

        if(ch[i] == ')'){
            return dp[i][cnt] = solve(cnt - 1, i + 1, ch, n);
        }

        return dp[i][cnt] = solve(cnt + 1, i + 1, ch, n) || solve(cnt - 1, i + 1, ch, n) || solve(cnt, i+1, ch, n);
    }

    
}