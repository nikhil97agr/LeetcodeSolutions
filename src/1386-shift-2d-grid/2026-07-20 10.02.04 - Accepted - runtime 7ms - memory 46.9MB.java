class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            List<Integer> temp = new ArrayList<>();

            for(int j=0;j<m;j++) temp.add(0);

            list.add(temp);
        }

        int len = m*n;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int ind = i*m + j;

                int nextInd = (ind + k)%len;
                int ni = nextInd/m;
                int nj = nextInd%m;

                list.get(ni).set(nj, grid[i][j]);
            }
        }

        return list;
    }
}