class Solution {
    public int longestCommonPrefix(String s, String t) {
        return solve(s.toCharArray(), t.toCharArray(), s.length(), t.length(), 0, 0, 1);
    }

    private int solve(char[] s, char[] t, int n, int m, int i, int j, int k ){
        if(i==n || j == m) return 0;

        if(s[i] == t[j]){
            return 1 + solve(s, t, n, m, i+1, j+1, k);
        }

        if(k==0) return 0;
        return solve(s, t, n, m, i+1, j, k-1);
    }
}