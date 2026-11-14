class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result[] = new int[m];
        for(int i=0;i<m;i++){
            int startCol = i;
            for(int j=0;j<n;j++){
                if(grid[j][startCol]==-1){
                    if(startCol==0||grid[j][startCol-1]==1){
                        result[i] = -1;
                        break;
                    }
                    startCol--;
                    continue;
                }
                    if(startCol==m-1|| grid[j][startCol+1]==-1){
                        result[i]  =-1;
                        break;
                    }
                    startCol++;
                
            }
            
            if(result[i]!=-1){
                result[i] = startCol;
            }
        }
        return result;
    }
}