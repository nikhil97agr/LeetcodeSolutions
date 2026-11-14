class Solution {

    boolean dp[][][];
    public boolean possiblyEquals(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        dp = new boolean[n+1][m+1][2000];

        return solve(s1.toCharArray(), s2.toCharArray(), 0, 0, 0, n, m);
    }

    private boolean solve(char c1[], char c2[], int i, int j, int diff, int n, int m){
        if(i == n && j == m){
            return diff == 0;
        }
        if(dp[i][j][1000 + diff]) return false;
        dp[i][j][1000 + diff] = true;
        if(i < n && isDigit(c1[i])){
            for(int val =0,start = i;start < n && isDigit(c1[start]);start++){
                val = val * 10 + (c1[start] - '0');
                if(solve(c1, c2, start + 1, j, diff- val, n, m))
                    return true;
            }
            return false;
        }

        if( j < m && isDigit(c2[j])){
            for(int val=0,start=j;start < m && isDigit(c2[start]); start++){
                val = val * 10 + (c2[start] - '0');
                if(solve(c1, c2, i, start + 1, diff + val, n, m)){
                    return true;
                }
            }
            return false;
        }

        if(diff > 0){
            return i < n && solve(c1, c2, i+1, j, diff - 1, n, m);
        }

        if(diff < 0){
            return j < m && solve(c1, c2, i, j+1, diff + 1, n, m);
        }

        return i < n && j < m && c1[i] == c2[j] && solve(c1, c2, i+1, j+1, diff, n, m);
    }

    private boolean isDigit(char c){
        return Character.isDigit(c);
    }
}