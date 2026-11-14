class Solution {
    Integer dp[][][];
    public int maxTastiness(int[] price, int[] tastiness, int maxAmount, int maxCoupons) {
        dp = new Integer[price.length][maxAmount+1][maxCoupons+1];
        return solve(0, price.length, price, tastiness, maxAmount, maxCoupons);
    }

    private int solve(int i, int n, int price[], int tastiness[], int amt, int coupon){
        if(i==n){
            return 0;
        }

        if(dp[i][amt][coupon] != null) return dp[i][amt][coupon];

        int ans = solve(i+1, n, price, tastiness, amt, coupon);

        if(price[i] <= amt){
            ans = Math.max(ans, tastiness[i] + solve(i+1, n, price, tastiness, amt - price[i], coupon));
        }

        if(coupon > 0 && price[i]/2  <= amt){
            ans = Math.max(ans, tastiness[i] + solve(i+1, n, price, tastiness, amt - price[i]/2, coupon - 1));
        }

        return dp[i][amt][coupon] = ans;
    }
}