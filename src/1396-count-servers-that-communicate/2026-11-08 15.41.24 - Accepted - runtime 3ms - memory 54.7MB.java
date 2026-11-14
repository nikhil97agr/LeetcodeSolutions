class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int rCnt[] = new int[m];
        int cCnt[] = new int[n];
        int total = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    total++;
                    rCnt[i]++;
                    cCnt[j]++;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    if(rCnt[i]==1 && cCnt[j]==1){
                        total--;
                    }
                }
            }
        }

        return total;
    }
}