package count_routes_to_climb_a_rectangular_grid_4153;

class Solution {
    public int numberOfRoutes(String[] grid, int d) {
        int n = grid.length;
        int m = grid[0].length();
        char mat[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            mat[i] = grid[i].toCharArray();
        }

        int dp[] = new int[m];

        for(int i=0;i<m;i++){
            if(mat[0][i] == '.'){
                dp[i] = 1;

                for(int j=0;j<m;j++){
                    if(i!=j && mat[0][j] == '.' && isSafe(0, i, 0, j, d)){
                        dp[i]++;
                    }
                }
            }
        }

        int r1 = (int)Math.sqrt(d*d -1);
        int r2 =d;

        for(int i=1;i<n;i++){
            int pre[] = new int[m];

            pre[0] = dp[0];
            for(int j=1;j<m;j++){
                pre[j] = sum(pre[j-1], dp[j]);
            }

            int temp[] = new int[m];
            for(int j=0;j<m;j++){
                if(mat[i][j] == '#') continue;
                int l = Math.max(0, j - r1);
                int r = Math.min(m-1, j + r1);

                if(r < l){
                    temp[j] = 0;
                }else if(l ==0){
                    temp[j] = pre[r];
                }else{
                    temp[j] = sum(pre[r], -pre[l-1]);
                }
            }
            pre = new int[m];
            pre[0] = temp[0];
            for(int j=1;j<m;j++){
                pre[j] = sum(pre[j-1], temp[j]);
            }

            int next[] = new int[m];

            for(int j=0;j<m;j++){
                if(mat[i][j] == '#') continue;

                int l= Math.max(0, j - r2);
                int r = Math.min(m-1, j + r2);

                int sum = 0;
                if(l==0){
                    sum = pre[r];
                    
                }else if(l <= r){
                    sum = sum(pre[r], -pre[l-1]);
                }

                sum = sum(sum, -temp[j]);

                next[j] = sum(temp[j], sum);
            }

            dp = next;
        }
        int ans = 0;
        for(int x : dp){
            ans = sum(ans, x);
        }

        return ans;
    }

    private boolean isSafe(int r1, int c1, int r2, int c2, int d){
        d = d*d;
        int dist = (int)Math.pow(r1 -r2, 2) + (int)Math.pow(c1-c2, 2);

        return dist <= d;
    }

    private int sum(int a, int b) {
        long mod = (long) 1e9 + 7;

        long sum = mod + a + b;

        return (int) (sum % mod);
    }
}