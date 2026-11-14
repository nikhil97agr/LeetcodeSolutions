package image_smoother_661;

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int res[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int di[] = new int[]{-1,-1,0, 1, 1, 1, 0, -1};
                int dj[] = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
                int sum = img[i][j];
                int count = 1;
                for(int k=0;k<8;k++){
                    int ni = di[k] + i;
                    int nj = dj[k] + j;
                    if(ni>=0 && nj>=0 && ni<m && nj < n){
                        count++;
                        sum += img[ni][nj];
                    }


                }
                res[i][j] = sum/ count;
            }
        }
        return res;
    }
}