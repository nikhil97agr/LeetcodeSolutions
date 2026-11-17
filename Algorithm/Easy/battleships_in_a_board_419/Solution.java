package battleships_in_a_board_419;

class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int ans = 0;
        boolean vis[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && board[i][j] == 'X'){
                    dfs(board, i, j, m, n, vis);
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(char board[][], int i, int j, int m, int n, boolean vis[][]){
        if(i <0 || j < 0 || i >=m || j >=n || board[i][j] == '.'|| vis[i][j]){
            return;
        }

        vis[i][j] =true;

        dfs(board, i+1, j, m, n, vis);
        dfs(board, i, j+1, m, n, vis);
    }
}