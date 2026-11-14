package equal_row_and_column_pairs_2428;

class Solution {
    public int equalPairs(int[][] grid) {
        int cnt = 0;
        int n = grid.length;
        
        for(int i=0;i<n;i++){
            
            for(int k=0;k<n;k++){
                boolean result = true;
                int j=0;
                int l = 0;
                while(j<n){
                    if(grid[i][j] != grid[l][k]){
                        result = false;
                        break;
                    }
                    l++;
                    j++;
                }

                if(result){
                    cnt++;
                }
            }

        }
        return cnt;
        
        
    }

    
}