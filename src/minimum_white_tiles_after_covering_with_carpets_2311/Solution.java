package minimum_white_tiles_after_covering_with_carpets_2311;

class Solution {
    public static void main(String[] args) {
        new Solution().minimumWhiteTiles("10110101", 2,2);
    }
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        int pre[] = new int[n+1];

        for(int i=1;i<=n;i++){
            if(floor.charAt(i-1)=='1'){
                pre[i] = pre[i-1] + 1;
            }else{
                pre[i] = pre[i-1];
            }
        }


        int ans = solve(numCarpets, carpetLen, 0, pre, floor.toCharArray(), n, new Integer[n][numCarpets+1]);


        return pre[n] - ans;


    }

    private int solve(int carpet, int len, int i, int pre[], char arr[], int n, Integer dp[][]){
        if(i==n || carpet ==0) return 0;
        

        if(dp[i][carpet]!=null) return dp[i][carpet];

        int ans = solve(carpet, len, i+1, pre, arr, n, dp);
        

        int include = pre[Math.min(n, i + len)] - pre[i] + solve(carpet -1 , len, Math.min(i+len, n), pre, arr, n, dp);

        return dp[i][carpet] = Math.max(ans, include);


    }
}