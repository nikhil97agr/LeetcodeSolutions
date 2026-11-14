class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int copy[][] = new int[m][n];

        for(int i=0;i<m;i++){
            copy[i] = board[i].clone();
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int cnt = getCnt(copy, i, j, m, n);
                if(copy[i][j] == 0){
                    if(cnt == 3){
                        board[i][j] = 1;
                    }
                }else{
                    if(cnt < 2 || cnt > 3) board[i][j] = 0;
                }
            }
        }
    }

    private int getCnt(int board[][], int i, int j, int m, int n){
        int dir[][] = {
             {0,1}, {0, -1},
            {1,0}, {1,1}, {1, -1},
            {-1,0}, {-1,1}, {-1, -1}
        };
        int cnt = 0;
        for(int d[] : dir){
            int ni = i + d[0];
            int nj = j + d[1];

            if(ni >=0 && nj >=0 && ni < m && nj < n && board[ni][nj]== 1){
                cnt++;
            }
        }

        return cnt;
    }
}