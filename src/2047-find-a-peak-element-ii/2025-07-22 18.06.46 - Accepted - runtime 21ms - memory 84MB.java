class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int val = mat[i][j];
                boolean flag =true;
                int dir[][] = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
                for(int d[] : dir){
                    int ni = i + d[0];
                    int nj = j + d[1];

                    if(ni >=0 && nj >=0 && ni < n && nj < m && mat[ni][nj] >= val){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    return new int[]{i,j};
                }
            }

        }

        return new int[2];
    }
}