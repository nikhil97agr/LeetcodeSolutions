package sudoku_solver_37;

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    private boolean solve(char[][] board, int point){
        if(point==81){
            return true;
        }

        int i = point/9;
        int j = point%9;

        if(board[i][j]=='.'){
            for(char r='1';r<='9';r++){
                board[i][j] = r;
                if(verify(board, i, j)){
                    if(solve(board, point+1))
                    {
                    return true;

                    }
                    else
                    board[i][j] = '.';
                }else{
                    board[i][j] = '.';
                }
            }
        }else{
            return solve(board, point+1);
        }

        return false;
    }

    private boolean verify(char[][] board, int i, int j){
        for(int r=i-1;r>=0;r--){
            if(board[r][j]!='.' && board[i][j]==board[r][j]){
                return false;
            }
        }

        for(int r = i+1;r<9;r++){
            if(board[r][j]!='.' && board[i][j] == board[r][j]){
                return false;
            }
        }
        for(int c=j-1;c>=0;c--){
            if(board[i][c]!='.' && board[i][j]==board[i][c]){
                return false;
            }
        }

        for(int c = j+1;c<9;c++){
            if(board[i][c] != '.' && board[i][j] == board[i][c]){
                return false;
            }
        }

        int rstart = (i/3)*3;
        int cstart = (j/3)*3;
        for(int r = rstart; r<=rstart+2;r++){
            for(int c=cstart;c<=cstart+2;c++){
                if(r==i&&c==j){
                    continue;
                }
                if(board[r][c]!='.' && (r!=i || c!=j) && board[i][j]==board[r][c]){
                    return false;
                }
            }
        }


        return true;
    }
}