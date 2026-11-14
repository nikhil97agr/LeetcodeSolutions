class Solution {
    double total = 0;
    double valid = 0;

    public double getProbability(int[] balls) {
        
        solve(balls, 0, 0, 0, 0, 0,1d);
        return valid / total;
    }

    private void solve(int balls[], int ind, int n1, int n2, int c1, int c2, double ways){
        if(ind == balls.length){
            if(n1 == n2){
                total += ways;

                if(c1 == c2) valid += ways;
            }

            return ;
        }

        int cnt = balls[ind];

        for(int c=0;c<=cnt;c++){
            int left = cnt - c;

            int nc1 = c1 + Math.min(1, c);
            int nc2 = c2 + Math.min(1, left);

            int t1 = n1 + c;
            int t2 = n2 + left;

            solve(balls, ind+1, t1, t2, nc1, nc2, ways * comb(cnt, c));
        }

        
    }

    private double comb(int n, int r){
             r = Math.min(r, n-r);
            if(r==0) return 1d;

            double ans = 1d;

            for(int i=1;i<=n;i++){
                ans *= i;
            }

            for(int i=1;i<=r;i++){
                ans/=i;
            }

            for(int i=1;i<=n-r;i++){
                ans/=i ;
            }

            return ans;
        }
}