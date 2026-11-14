class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int x = 0;
        int y = 0;
        int m =grid.length;
        int n =grid[0].length;
        boolean vis[][] = new boolean[m][n];
        int i=0;
        int j=0;
        while(i >=0 && j >=0 && i < m && j < n && !vis[i][j]){
            x = i;
            y = j;
            vis[i][j] =true;

            char c = grid[i][j];
            if(c == 'R'){
                j++;
            }else if(c== 'L'){
                j--;
            }else if(c == 'U'){
                i--;
            }else{
                i++;
            }

        }

        return new int[]{x, y};
    }
}