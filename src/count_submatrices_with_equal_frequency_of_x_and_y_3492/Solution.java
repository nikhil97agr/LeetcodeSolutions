package count_submatrices_with_equal_frequency_of_x_and_y_3492;

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        Pair[][] pair = new Pair[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int x = grid[i][j] == 'X' ? 1 : 0;
                int y = grid[i][j] == 'Y' ? 1 : 0;
                if(i==0 && j==0){
                    pair[i][j] = new Pair(x, y);
                    continue;
                }
                
                if(i==0){
                    pair[i][j] = new Pair(x, y);
                    pair[i][j].x += pair[i][j-1].x;
                    pair[i][j].y += pair[i][j-1].y;
                    
                }else if(j==0){
                    pair[i][j] = new Pair(x,y);
                    pair[i][j].x += pair[i-1][j].x;
                    pair[i][j].y += pair[i-1][j].y;
                }else{
                    pair[i][j] = new Pair(x,y);
                    pair[i][j].x += pair[i-1][j].x + pair[i][j-1].x - pair[i-1][j-1].x;
                    pair[i][j].y += pair[i-1][j].y + pair[i][j-1].y - pair[i-1][j-1].y;
                }
                
                if(pair[i][j].x == pair[i][j].y && pair[i][j].x !=0) ans++;
            }
        }
        return ans;
    }
    
    class Pair{
        int x;
        int y;
        
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public String toString(){
            return ""+x+":"+y;
        }
    }
}