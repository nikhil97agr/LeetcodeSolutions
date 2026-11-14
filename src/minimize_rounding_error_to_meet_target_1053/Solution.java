package minimize_rounding_error_to_meet_target_1053;

class Solution {
    public String minimizeError(String[] prices, int target) {
        int n = prices.length;
        int nums[] = new int[n];
        double deltaCeil[] = new double[n];
        double deltaFloor[] = new double[n];
        for(int i=0;i<n;i++){
            double val = Double.parseDouble(prices[i]);
            int v = (int)val;
            target -= v;

            if(target < 0) return "-1";
            if(val - v == 0d){
                nums[i] = 0;
                deltaFloor[i] = deltaCeil[i] = 0;
            }else{
                nums[i] = 1;
                deltaFloor[i] = val - v;
                deltaCeil[i] = (v + 1 ) - val;
            }
        }

        Double dp[][] = new Double[n][target+1];
        double result = solve(0,  target, n, nums, deltaCeil, deltaFloor, dp);
        if(result == Double.MAX_VALUE) return "-1";
        String ans =  String.valueOf(result);
        int ind = ans.indexOf(".");
        if(ind == -1){
            ans += "000";
        }else{
            int len = ans.substring(ind + 1).length();
            int req = 3 - len;
            while(req > 0){
                req--;
                ans += "0";
            }
        }

        return ans;
    }

    private double solve(int i,  int target, int n, int nums[], double ceil[], double floor[], Double dp[][]){
        if(i==n){
            if(target == 0) return 0;
            return Double.MAX_VALUE;
        }
        if(target < 0) return Double.MAX_VALUE;

        if(dp[i][target] !=null) return dp[i][target];

        double a = solve(i+1, target, n, nums, ceil, floor, dp);
        double b = solve(i+1,  target - nums[i], n, nums, ceil, floor, dp);
        if(a!= Double.MAX_VALUE){
            a += floor[i];
            a = (1d*Math.round(a * 1000))/1000d;
        }

        if(b != Double.MAX_VALUE){
            b += ceil[i];
            b = (1d*Math.round(b * 1000))/1000d;

        }

        return dp[i][target] = Math.min(a,b);
    }
}