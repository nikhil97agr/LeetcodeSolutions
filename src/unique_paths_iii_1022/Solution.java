package unique_paths_iii_1022;

class Solution {
    
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int startX=-1;
        int startY=-1;
        int endX=-1;
        int endY=-1;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 || grid[i][j]==0){
                    count++;
                }
                if(grid[i][j]==1){
                    startX = i;
                    startY = j;
                }
                if(grid[i][j]==2){
                    endX = i;
                    endY = j;
                }
            }
        }
        return check(m, n, grid, startX, startY, endX, endY, count, 0);
    }

    private int check(int m, int n, int grid[][], int xi, int yi, int xf, int yf, int count, int total){
        if(xi<0 || xi>=m || yi <0 || yi >=n){
            return 0;
        }

        if(grid[xi][yi]==-2 || grid[xi][yi]==-1){
            return 0;
        }
        if(xi==xf && yi == yf){
            if(total==count){
               
                return 1;
            }
            return 0;
        }

        int ans = 0;
        grid[xi][yi]=-2;
        int diffX[] = new int[]{0,0,-1,1};
        int diffY[] = new int[]{-1,1,0,0};
        for(int i=0;i<4;i++){
            ans += check(m,n, grid,xi + diffX[i], yi + diffY[i], xf, yf, count, total+1);
        }

        grid[xi][yi]=0;
        return ans;

    }
}