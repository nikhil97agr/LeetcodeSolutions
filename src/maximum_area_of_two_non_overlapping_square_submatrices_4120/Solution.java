package maximum_area_of_two_non_overlapping_square_submatrices_4120;

class Solution {
    public int maxArea(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int pref[][] = new int[m + 1][n + 1];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pref[i + 1][j + 1] = mat[i][j] + pref[i][j+1] + pref[i+1][j] - pref[i][j];
            }
        }

        int start = 1;
        int end = Math.min(m,n);
        int k = 0;

        while( start <= end){
            int mid = (start + end)/2;

            if(possible(mat, pref, m, n, mid)){
                k = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return k * k;
    }

    private boolean possible(int mat[][], int pre[][], int m, int n, int mid){
         int max = Integer.MAX_VALUE;
        int minBottom = max;
        int maxTop = Integer.MIN_VALUE;
        int minRight = max;
        int maxLeft = Integer.MIN_VALUE;
        int cnt = 0;
        for(int r=0;r<=m-mid;r++){
            for(int c=0;c<=n-mid;c++){
                int total = pre[r + mid][c + mid] - pre[r][c + mid] - pre[r + mid][c] + pre[r][c];
                if(total == mid * mid){
                    cnt++;
                    minBottom = Math.min(minBottom, r + mid - 1);
                    maxTop = Math.max(maxTop, r);
                    minRight = Math.min(minRight, c + mid -1 );
                    maxLeft = Math.max(maxLeft, c);
                }
            }
        }

        if(cnt < 2) return false;

        return maxTop > minBottom || maxLeft > minRight;
    }
}