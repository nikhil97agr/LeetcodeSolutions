package form_largest_integer_with_digits_that_add_up_to_target_1545;

class Solution {
    String dp[][];
    public String largestNumber(int[] cost, int target) {
        dp = new String[target+1][10];
        return solve(cost, target, 9);
    }
    
    private String solve(int cost[], int target, int num){
        if(target == 0) return "";
        if(num ==0) return "0";
        if(dp[target][num]!=null) return dp[target][num];
        String res = "0";
        if(cost[num-1] <= target){
            String next = solve(cost, target - cost[num-1], num);
            if (!next.equals("0")) {
                res = num + next;
            }
        }
        
        String next = solve(cost, target, num - 1);
        
        if(next.length() > res.length() || (next.length()== res.length() && next.compareTo(res) > 0)){
            res = next;
        }
        
        return dp[target][num] = res;
    }
}