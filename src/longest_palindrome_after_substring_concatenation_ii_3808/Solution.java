package longest_palindrome_after_substring_concatenation_ii_3808;

import java.util.*;
class Solution {
    public int longestPalindrome(String s, String t) {
        int n = s.length();
        int m = t.length();
        char c1[] = s.toCharArray();
        char c2[] = t.toCharArray();

        int d1[]= getCnt(c1, n, false);
        int d2[] =getCnt(c2, m, true);

        int dp[][] = new int[n][m];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<m;j++){
                if(c1[i] != c2[j]){
                    dp[i][j] = max(d1[i], d2[j]);
                }else{

                    dp[i][j] = 2;
                    if(i + 1 < n){
                        dp[i][j] = max(dp[i][j], d1[i+1] + 2);
                    }

                    if( j - 1 >=0){
                        dp[i][j] = max(dp[i][j], d2[j-1] + 2);
                    }

                    if( i + 1 < n && j - 1 >=0){
                        dp[i][j] = max(dp[i][j], dp[i+1][j-1] + 2);
                    }

                    dp[i][j] = max(dp[i][j], d1[i], d2[j]);
                }
            }
        }
        
 
        return Arrays.stream(dp).mapToInt(x-> max(x)).boxed().max(Integer::compareTo).get();
    }

    private int[] getCnt(char c[], int n, boolean rev){
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        int dp[][] = new int[n][n];

        for(int i=0;i<n;i++) dp[i][i] =1;

        for(int i=n-1;i>=0;i--){
            for(int j= i + 1;j < n;j++){
                if(j - i == 1){
                    if(c[i] == c[j]){
                        dp[i][j] = 2;
                    }
                }else if(c[i] == c[j]){
                    if(dp[i+1][j-1] == (j - i - 1)){
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }
                }
            }
        }
        if(!rev){
            for(int i=0;i<n;i++){
                ans[i] = Arrays.stream(dp[i]).max().getAsInt();
            }
        }else{
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    ans[j] = Math.max(ans[j], dp[i][j]);
                }
            }
        }

        return ans;
    }

    int max(int...arr){
        return Arrays.stream(arr).max().getAsInt();
    }
}