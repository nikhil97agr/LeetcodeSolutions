class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[][] = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Set<Integer> lt = new HashSet<>();
                Set<Integer> br = new HashSet<>();

                for(int k=i-1, l=j-1;k >=0 && l >=0;k--,l--){
                    lt.add(grid[k][l]);
                }

                for(int k=i+1, l=j+1;k<n && l < m; k++,l++){
                    br.add(grid[k][l]);
                }

                ans[i][j] = Math.abs(lt.size() - br.size());
            }
        }

        return ans;
    }
}