package flipping_an_image_861;

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        int ans[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int k=0,j=n-1;k<n && j>=0;j--,k++){
                ans[i][k] = image[i][j] == 0 ? 1 : 0;
            }
        }
        return ans;
    }
}