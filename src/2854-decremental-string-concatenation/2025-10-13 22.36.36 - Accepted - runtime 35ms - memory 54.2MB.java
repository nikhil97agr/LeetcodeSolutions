class Solution {
    public int minimizeConcatenatedLength(String[] words) {
        Integer dp[][][] = new Integer[words.length][26][26];
        return words[0].length() + solve(1, words, words.length, words[0].charAt(0), words[0].charAt(words[0].length()-1), dp);
    }
    
    private int solve(int i, String words[], int n, char first, char last, Integer dp[][][]){

        if(i==n) return 0;

        int i1 = first - 'a';
        int i2 = last - 'a';

        if(dp[i][i1][i2]!=null) return dp[i][i1][i2];

        int ans = Integer.MAX_VALUE;
        int len = words[i].length() ;
        if(words[i].charAt(0) == last){
            ans = len - 1 + solve(i+1, words, n, first, words[i].charAt(len-1), dp);
        }else{
            ans = len + solve(i+1, words, n, first, words[i].charAt(len - 1), dp);
        }

        if(words[i].charAt(len -1) == first){
            ans = Math.min(ans, len-1 + solve(i+1, words, n, words[i].charAt(0), last, dp));
        }else{
            ans = Math.min(ans, len + solve(i+1, words, n, words[i].charAt(0), last, dp));
        }

        return dp[i][i1][i2] = ans;
    }
}