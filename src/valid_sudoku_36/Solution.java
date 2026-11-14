package valid_sudoku_36;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        boolean row[][] = new boolean[n][10];
        boolean column[][] = new boolean[n][10];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int num =board[i][j]-'0';
                if(row[i][num] || column[j][num]){
                    return false;
                }
                row[i][board[i][j]-'0'] = true;

                column[j][board[i][j]-'0'] = true;
                int ind1 = i-i%3;
                int ind2 = j-j%3;
                for(int k=ind1;k<ind1+3;k++){
                    for(int l=ind2;l<ind2+3;l++){
                        if((k!=i&&l!=j)&&board[i][j]==board[k][l]){
                            return false;
                        }
                    }
                }

            }
        }
        return true;
    }
}