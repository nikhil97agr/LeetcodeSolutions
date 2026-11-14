package design_tic_tac_toe_348;

class TicTacToe {
    int n;
    int row[][];
    int col[][];
    int d1[];
    int d2[];
    public TicTacToe(int n) {
        row = new int[n][2];
        col = new int[n][2];
        this.n = n;
        d1 = new int[2];
        d2 = new int[2];
    }
    
    public int move(int row, int col, int player) {
        this.row[row][player-1]++;
        this.col[col][player-1]++;
        if(row == col) d1[player-1]++;
        if(row + col == n-1) d2[player-1]++;

        if(this.row[row][player-1] == n || this.col[col][player-1] == n || d1[player-1] == n || d2[player-1] == n) return player;

        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */