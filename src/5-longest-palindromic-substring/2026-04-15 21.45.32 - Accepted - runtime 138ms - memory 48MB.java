class Solution {
    public String longestPalindrome(String s) {
        var n = s.length();
        boolean dp[][] = new boolean[n][n];
        for(int i=0;i<n;i++) dp[i][i] = true;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(i + 1 == j){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
            }
        }

        int len = 1;
        int start = 0;
        int end = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(!dp[i][j]) continue;

                if(len < j - i + 1){
                    start = i;
                    end = j;
                    len = j -i + 1;
                }
            }
        }

        return s.substring(start, end + 1);

    }
}