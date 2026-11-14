package count_the_number_of_winning_sequences_3588;

class Solution {
    /**
        0 : Fire Dragon
        1 : Water Serpent
        2 : Earth Golem

        0 > 2, 1 > 0, 2 > 1
     */
    public int countWinningSequences(String s) {
        int n = s.length();
        int arr[] = new int[n];
        Integer dp[][][] = new Integer[n][2*n + 1][4];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            switch(c){
                case 'F':
                arr[i] = 0;
                break;
                case 'W':
                arr[i] = 1;
                break;
                case 'E':
                arr[i] = 2;
                break;
            }
        }

        return solve(0, 0,  3, arr, n, dp);
    }

    private int solve(int b, int ind, int prev, int arr[], int n, Integer dp[][][]){
        if(ind==n){
            return b > 0 ? 1 : 0;
        }

        if(dp[ind][n + b][prev]!=null) {
            return dp[ind][n+b][prev];
        }

        int ans = 0;
        for(int i=0;i<3;i++){
            if(i != prev){
                switch(arr[ind]){
                    case 1:
                    if(i==2){
                        ans = add(ans, solve( b+1, ind+1, i, arr, n, dp));
                    }else if(i==0){
                        ans = add(ans, solve(b-1, ind+1, i, arr, n, dp));
                    }else{
                        ans = add(ans, solve(b,ind+1, i, arr, n, dp));
                    }
                    break;
                    case 2:
                    if(i==0){
                        ans = add(ans, solve( b+1, ind+1, i, arr, n, dp));
                    }else if(i==1){
                        ans = add(ans, solve(b-1, ind+1, i, arr, n, dp));
                    }else{
                        ans = add(ans, solve( b,ind+1, i, arr, n, dp));
                    }
                    break;
                    case 0:
                    if(i==1){
                        ans = add(ans, solve( b+1, ind+1, i, arr, n, dp));
                    }else if(i==2){
                        ans = add(ans, solve(b-1, ind+1, i, arr, n, dp));
                    }else{
                        ans = add(ans, solve( b,ind+1, i, arr, n, dp));
                    }
                    break;
                }
            }
        }

        return dp[ind][n+b][prev] = ans;
    }

    private int add(int a, int b){
        int mod = (int)1e9 + 7;
        return (a%mod + b%mod)%mod;
    }
}