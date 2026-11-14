class Solution {

    Integer dp[][][][];

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        dp = new Integer[m][n][m][n];
        return solve(horizontalCut, verticalCut, 0, 0, m-2, n-2);
    }

    private int solve(int hcost[], int vcost[], int x1, int y1, int x2, int y2){
        if(x1 > x2){
            int sum = 0;
            for(int i=y1;i<=y2;i++){
                sum += vcost[i];
            }
            return sum;
        }
        
        if(y1 > y2){
            int sum = 0;
            for(int i=x1;i<=x2;i++){
                sum += hcost[i];
            }
            return sum;
        }
        
        if(dp[x1][y1][x2][y2] != null) return dp[x1][y1][x2][y2];
        int ans = Integer.MAX_VALUE;
        if(x1 ==x2){
            int sum =hcost[x1];

            for(int i=y1;i<=y2;i++){
                sum += vcost[i]*2;
            }
            ans = min(sum, ans);
        }else{
            for(int i=x1;i<=x2;i++){
                ans = min(ans, hcost[i] + solve(hcost, vcost,x1, y1, i-1, y2) + solve(hcost, vcost, i+1, y1, x2, y2));
            }
        }

        if(y1 == y2){
            int sum = vcost[y1];
            for(int i=x1;i<=x2;i++){
                sum +=hcost[i]*2;
            }
            ans = min(ans, sum);
        }else{
            for(int i=y1;i<=y2;i++){
                ans = min(ans, vcost[i] + solve(hcost, vcost, x1, y1, x2, i-1) + solve(hcost, vcost, x1, i+1, x2, y2));
            }
        }








        return dp[x1][y1][x2][y2] = ans;



    }

    private int min(int a, int b){
        return Math.min(a, b);
    }
}