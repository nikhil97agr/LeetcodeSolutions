class Solution {
    public int boxDelivering(int[][] boxes, int p, int b, int w) {
        int n = boxes.length;
        int dp[] = new int[n+1];
        int extra = 0;
        int lastDifferent = 0;
        Arrays.fill(dp, 2_000_000);
        dp[0] = 0;
        for(int i=0,j=0;i<n;i++){
            while(j < n && b > 0 && w >= boxes[j][1]){
                b--;
                w-= boxes[j][1];
                if( j==0 || (boxes[j][0] != boxes[j-1][0])){
                    extra++;
                    lastDifferent = j;
                }

                j++;
            }

            dp[j] = Math.min(dp[j], dp[i] + extra + 1);
            dp[lastDifferent] = Math.min(dp[lastDifferent], dp[i] + extra);

            b++;
            w += boxes[i][1];
            if( i == n-1 || boxes[i][0] != boxes[i+1][0]){
                extra--;
            }
        }

        return dp[n];
    }
}