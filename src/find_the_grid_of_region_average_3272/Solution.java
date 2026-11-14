package find_the_grid_of_region_average_3272;

class Solution {
    public int[][] resultGrid(int[][] image, int threshold) {
        int n = image.length;
        int m =image[0].length;

        Cell cell[][] = new Cell[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                cell[i][j] =new Cell();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isRegion(image, i, j, threshold, n, m)){
                    int avg = calc(image, i, j);
                    update(cell, i, j, avg);
                }
            }
        }
        int ans[][] = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(cell[i][j].cnt ==0){
                    ans[i][j] = image[i][j];
                }else{
                ans[i][j] = cell[i][j].intensity/cell[i][j].cnt;

                }
            }
        }

        return ans;
    }

    private void update(Cell cell[][], int i, int j, int avg){
        for(int r=i;r<=i+2;r++){
            for(int c=j;c<=j+2;c++){
                cell[r][c].intensity += avg;
                cell[r][c].cnt++;
            }
        }
    }

    private int calc(int image[][], int i, int j){
        int sum = 0;
        for(int r=i;r<=i+2;r++){
            for(int c=j;c<=j+2;c++){
                sum += image[r][c];
            }
        }

        return sum / 9;
    }

    private boolean isRegion(int image[][], int i, int j, int threshold, int n, int m){
        if(i +2 >=n || j+2>=m) return false;
        int dir[][] = new int[][]{
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };
        for(int r=i;r<=i+2;r++){
            for(int c = j;c<=j+2;c++){
                for(int d[] : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr >=i && nc >=j && nr <=i+2 && nc <= j+2 && Math.abs(image[r][c] - image[nr][nc]) > threshold) return false;
                }
            }
        }
        return true;
    }

    class Cell{
        int intensity;
        int cnt;
        public Cell(){
            this.cnt= 0;
            this.intensity = 0;
        }
    }
}