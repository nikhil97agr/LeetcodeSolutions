package word_search_79;

class Solution {
    public boolean exist(char[][] board, String word) {
        boolean [][] traversed = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean visited[][] = new boolean[board.length][board[i].length];
                if(traversed[i][j]){
                    continue;
                }
                traversed[i][j] = true;
                if (check(board, word, 0, i, j, visited, board.length, board[i].length, traversed)) {
                    return true;
                }
            }
        }
        return false;
    }


    public  boolean check(char[][] board, String word, int index, int i, int j, boolean[][] visited, int n,
            int m, boolean [][] traversed) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }

        if (visited[i][j]) {
            return false;
        }
        if (word.charAt(index) == board[i][j]) {
            visited[i][j] = true;
            if (check(board, word, index + 1, i + 1, j, visited, n, m, traversed)
                    || check(board, word, index + 1, i - 1, j, visited, n, m, traversed)
                    || check(board, word, index + 1, i, j + 1, visited, n, m, traversed)
                    || check(board, word, index + 1, i, j - 1, visited, n, m, traversed)) {
                return true;
            }
        }
        visited[i][j] = false;
        // if(i+1<n&&!traversed[i+1][j]){
        //     traversed[i+1][j] = true;
        //     visited = new boolean[n][m];
        //     if(check(board, word, 0, i+1, j, visited, n, m, traversed)){
        //         return true;
        //     }
        // }
        // if(i-1>=0 &&!traversed[i-1][j]){
        //     traversed[i-1][j] = true;
        //     visited = new boolean[n][m];
        //     if(check(board, word, 0, i-1, j, visited, n, m, traversed)){
        //         return true;
        //     }
        // }
        // if(j+1<m&&!traversed[i][j+1]){
        //     traversed[i][j+1] = true;
        //     visited = new boolean[n][m];
        //     if(check(board, word, 0, i, j+1, visited, n, m, traversed)){
        //         return true;
        //     }
        // }
        // if(j-1>=0&&!traversed[i][j-1]){
        //     traversed[i][j-1] = true;
        //     visited = new boolean[n][m];
        //     if(check(board, word, 0, i, j-1, visited, n, m, traversed)){
        //         return true;
        //     }
        // }
        return false;
    }
}