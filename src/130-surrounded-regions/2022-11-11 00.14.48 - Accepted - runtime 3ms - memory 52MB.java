class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        if(m<=2||n<=2){
            return ;
        }

        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                board[0][i] = '.';
                update(board, 0,i+1,m,n);
                update(board, 1,i,m,n);
            }
            if(board[m-1][i]=='O'){
                board[m-1][i] = '.';
                update(board, m-1, i+1, m, n);
                update(board, m-2, i, m ,n);
            }
        }
        for(int j=0;j<m;j++){
            if(board[j][0]=='O'){
                board[j][0] = '.';
                update(board, j+1, 0, m, n);
                update(board, j, 1, m, n);
            }
            if(board[j][n-1]=='O'){
                board[j][n-1] = '.';
                update(board, j+1, n-1, m, n);
                update(board, j, n-2, m, n);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                    continue;
                }
                if(board[i][j]=='.'){
                    board[i][j] = 'O';
                }
            }
        }

        
    }

    public void update(char [][]board, int i, int j, int m, int n){
        if(i<0||i>=m||j<0||j>=n||board[i][j]!='O'){
            return ;
        }
        board[i][j] = '.';
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1, 0, 0};
        for(int k=0;k<4;k++){
            update(board, i+dx[k], j+dy[k], m, n);
        }
    }
}