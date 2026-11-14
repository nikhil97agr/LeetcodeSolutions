package cyclically_shift_rows_and_columns_4416;

class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int ans[][] = new int[n][n];
        for(int i=0;i<n;i++){
            ans[i] = grid[i].clone();
        }
        for(int i=0;i<rowShift.length;i++){
             ans[i] = rotateR(ans[i], rowShift[i],  n);
        }

        for(int j=0;j<colShift.length;j++){
            rotateC(ans, colShift[j], n, j);
        }

        return ans;
    }

    private void rotateC(int arr[][], int cnt, int n,int col){
        int temp[] = new int[n];


        for(int j=0;j<n;j++){
            temp[(j - cnt + n)%n] = arr[j][col];
        }

        for(int j=0;j<n;j++){
            arr[j][col] = temp[j];
        }

    }

    private int[] rotateR(int arr[], int cnt, int n){
        int temp[] = new int[n];

        for(int i=0;i<n;i++){
            temp[(i - cnt + n)%n] = arr[i];
        }

        return temp;
    }
}