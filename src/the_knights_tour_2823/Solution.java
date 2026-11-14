package the_knights_tour_2823;

class Solution {
    public int[][] tourOfKnight(int m, int n, int r, int c) {
        int ans[][] = new int[m][n];
        boolean vis[][] = new boolean[m][n];
        int cnt = 0;
        traverse(m,n, r, c, ans, vis, cnt);

        return ans;
    }

    private boolean traverse(int m, int n, int r, int c, int ans[][], boolean vis[][], int cnt){
        if(r < 0 || c < 0 || r >=m || c >= n || vis[r][c]) return false;
        
        vis[r][c] = true;
        ans[r][c] = cnt;
        cnt++;
        if(cnt == m*n) return true;

        int diff[][] = new int[][]{
            {1,2},
            {1,-2},
            {-1,2},
            {-1,-2},
            {2,1},
            {-2,1},
            {2,-1},
            {-2,-1}
        };

        for(int d[] : diff){
            int nr = r + d[0];
            int nc = c + d[1];

            if(traverse(m, n, nr, nc, ans, vis, cnt)) return true;
        }


        vis[r][c]= false;
        return false;
    }
}