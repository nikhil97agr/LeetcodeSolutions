package count_of_integers_2757;

class Solution {
    public int count(String num1, String num2, int min_sum, int max_sum) {
        int a = solve(0, 0, 1, max_sum, min_sum, num1.length(), num1.toCharArray(), new Integer[num1.length()][num1.length()*10][2]);
        int b = solve(0, 0, 1, max_sum, min_sum, num2.length(), num2.toCharArray(), new Integer[num2.length()][num2.length()*10][2]);
        int sum = 0;
        for(char c : num1.toCharArray()){
             sum += (c-'0');
        }

        int extra = 0;
        if(min_sum <= sum && sum <= max_sum) extra = 1;
        return add(add(b, -a), extra) ;
    }


    private int solve(int i, int sum,int flag, int max, int min, int len, char digit[], Integer dp[][][]){
        
        if( i == len){
            if(min <= sum && sum <= max) return 1;
            return 0;
        }

        if(dp[i][sum][flag] !=null) return dp[i][sum][flag];

        int ans = 0;

        if(flag == 0){
            for(int j=0;j<=9;j++){
                int total = sum + j;

                ans = add(ans, solve(i+1, total, flag, max, min, len, digit, dp));
            }
        }else{
            int dig = digit[i] - '0';

            for(int j=0;j<dig;j++){
                int total = sum + j;
                ans = add(ans, solve(i+1, total, 0, max, min, len, digit, dp));
            }

            ans =add(ans, solve(i+1, sum + dig, 1, max, min, len, digit, dp));
        }



        return dp[i][sum][flag] = ans;


    }

    private int add(int a, int b){
        long mod = (long)1e9 + 7;

        long sum = mod + a + b;
        return (int)(sum%mod);
    }
}