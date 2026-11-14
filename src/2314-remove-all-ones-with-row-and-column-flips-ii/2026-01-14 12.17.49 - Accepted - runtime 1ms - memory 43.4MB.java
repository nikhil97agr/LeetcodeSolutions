class Solution {
    public int removeOnes(int[][] grid) {
        int n= grid.length;
        int m = grid[0].length;

        return solve( n, m, grid);
    }

    private int solve( int n, int m, int grid[][]){
        boolean found = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    found= true;
                    break;
                }
            }
        }
        
        if(!found) return 0;

        int ans= n*m;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    int clone[][] = new int[n][m];
                    for(int k=0;k<n;k++){
                        clone[k] = grid[k].clone();
                    }
                    for(int k=0;k<n;k++){
                        clone[k][j] = 0;
                    }

                    for(int k=0;k<m;k++){
                        clone[i][k] = 0;
                    }

                    ans = Math.min(ans, 1 + solve(n, m, clone));
                }
            }
        }


        return ans;
    }
}