class Solution {
    public int tilingRectangle(int n, int m) {
        int mat[][] = new int[n][m];

        AtomicInteger result = new AtomicInteger(n*m);
        solve(mat, n,m,0, result);
        return result.get();
    }

    private void solve(int mat[][],int n, int m, int cnt, AtomicInteger result){
        if(result.get() < cnt) return ;


        int startX = -1;
        int startY = -1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] != 1){
                    startX = i;
                    startY = j;
                    break;
                }
            }

            if(startX != -1){
                break;
            }
        }

        if(startX == -1){
            result.set(Math.min(result.get(), cnt));
            return;
        }

        int len = findLength(mat, n, m, startX, startY);

        while(len >=1){
            fill(mat, startX, startY, len, 1);
            solve(mat, n, m, cnt+1, result);
            fill(mat, startX, startY, len, 0);
            len--;
        }
    }

    private void fill(int mat[][], int x, int y, int len, int val){
        for(int i=x;i<x+len;i++){
            for(int j=y;j<y+len;j++){
                mat[i][j] = val;
            }
        }
    }
    private int findLength(int mat[][], int n, int m, int x, int y){
        int len =1;
        while(x + len < n && y + len < m){
            boolean res = true;
            for(int i=0;i<=len;i++){
                if(mat[x + i][y+len] == 1 || mat[x + len][y+i] == 1){
                    res= false;
                    break;
                }
            }

            if(res){
                len++;
            }else{
                break;
            }
        }

        return len;
    }
}