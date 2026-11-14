import java.util.Arrays;

class Solution {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;

        Cuboid cub[] = new Cuboid[n+1];
        cub[0] = new Cuboid(0,0,0);
        for(int i=0;i<n;i++){
            cub[i+1] = new Cuboid(cuboids[i]);
        }

        Arrays.sort(cub, (a,b)->{
            if(a.l == b.l){
                if(a.w == b.w){
                    return a.h - b.h;
                }
                
                return a.w - b.w;
            }

            return a.l - b.l;
        });
        Integer dp[][] =new Integer[n+2][n+2];
        return solve(0, 1, n+1, cub, dp);
    }

    private int solve(int prev, int i, int n, Cuboid cub[], Integer dp[][]){
        if(i==n) return 0;


        if(dp[prev][i] !=null) return dp[prev][i];

        int ans = solve(prev, i+1, n, cub, dp);

        if(cub[prev].l <= cub[i].l && cub[prev].w <= cub[i].w && cub[prev].h <= cub[i].h){
            ans= Math.max(ans, solve(i, i+1, n, cub, dp) + cub[i].h);

        }

        return dp[prev][i] = ans;
    }

    class Cuboid{
        int l;
        int h;
        int w;

        public Cuboid(int...dim){
            Arrays.sort(dim);
            l = dim[0];
            w = dim[1];
            h = dim[2];
        }
    }
}