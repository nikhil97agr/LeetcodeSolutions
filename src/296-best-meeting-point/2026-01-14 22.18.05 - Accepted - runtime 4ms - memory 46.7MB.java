class Solution {
    public int minTotalDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int rowCount[] = new int[n];
        int colCount[] = new int[m];
        int totalDist = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                    totalDist += i + j;
                }
            }
        }

        int rowSuff[] = new int[n];
        int colSuff[] = new int[m];
        rowSuff[n-1] = rowCount[n-1];
        for(int i= n-2;i>=0;i--){
            rowSuff[i] += rowSuff[i+1] + rowCount[i];
        }

        colSuff[m-1] = colCount[m-1];
        for(int i=m-2;i>=0;i--){
            colSuff[i] += colSuff[i+1] + colCount[i];
        }


        int ans = totalDist;
        int row = 0;
        // int c1 = -1;
        // int c2 = -1;
        for(int i=0;i<n;i++){
            int dist = totalDist;
            int col = 0;
            for(int j=0;j<m;j++){
                // if(dist < ans){
                //     c1 = i;
                //     c2 = j;
                // }
                ans = Math.min(ans, dist);
                col += colCount[j];
                dist+= col;
                if(j+1 < m){
                    dist -= colSuff[j+1];
                }
            }
            // if(dist < ans){
            //     c1 = i;
            //     c2 = m-1;
            // }
            ans = Math.min(ans, dist);
            row += rowCount[i];
            totalDist += row;
            if(i+1 < n){
                totalDist -= rowSuff[i+1];
            }


        }
        return ans;
    }
}