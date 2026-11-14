package find_the_number_of_possible_ways_for_an_event_3604;

class Solution {
    int fact[];
    int inv[];
    int mod = (int)1e9 + 7;
    int max = 1001;
    public int numberOfWays(int n, int x, int y) {
        fact = new int[max];
        inv= new int [max];
        fact[0] = fact[1] = inv[0] = inv[1] = 1;
        for(int i=2;i< max;i++){
            fact[i] = prod(fact[i-1], i);

            inv[i] = pow(fact[i], mod - 2);
        }

        var ans = 0;
        var dp = new int[max][max];

        dp[0][0] = 1;
        for(int i=1;i< max;i++){
            for(int j=1;j<=i;j++){
                dp[i][j] = prod(j, add(dp[i-1][j-1], dp[i-1][j]));
            }
        }

        for(int i=1;i<=Math.min(n,x);i++){
            ans = add(ans, prod(pow(y, i), prod(comb(x, i), dp[n][i])));
        }

        return ans;
    }

    private int comb(int n, int r){

        if(r > n) return 0;
        if(n==r) return 1;
        return prod(fact[n], prod(inv[r], inv[n-r]));
    }

    private int add(int a, int b){
        long sum = 1l * a + b+ mod;

        return (int)(sum%mod);
    }

    private int prod(int a, int b){
        long p = 1l * a * b;
        return (int)(p%mod);
    }

    private int pow(int a,int b){
        if(a==0 || b==1) return a;
        if(b==1 || b==0) return 1;

        int p = pow(a, b/2);
        p =prod(p,p);
        if(b%2==1){
            p= prod(p,a);
        }

        return p;
    }
}