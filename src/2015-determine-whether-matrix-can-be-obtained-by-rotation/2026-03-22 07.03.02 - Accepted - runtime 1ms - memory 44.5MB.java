class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        for(int i=0;i<=n*n;i++){
            mat = rotate(mat);
            if(equals(mat, target)) return true;
        }


        return false;
    }

    private int[][] rotate(int arr[][]){
        int n = arr.length;

        int temp[][] = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp[j][n-i-1] = arr[i][j];
            }
        }

        return temp;
    }

    private boolean equals(int a[][], int b[][]){
        int n =a.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] != b[i][j]) return false;
            }

            
        }

        return true;
    }
}