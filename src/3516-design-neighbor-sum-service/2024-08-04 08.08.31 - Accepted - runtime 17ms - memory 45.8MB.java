class neighborSum {
    int arr[][];
    int n;
    int m;
    public neighborSum(int[][] grid) {
        arr = grid;
         n = grid.length;
    }
    
    public int adjacentSum(int value) {
        int ans = 0;
        
        int i1 = -1;
        int i2= -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == value){
                    i1 = i;
                    i2 = j;
                    break;
                }
            }
        }
        if(i1 == -1) return 0;
        
        if(i1-1 >=0){
            ans += arr[i1-1][i2];
        }
        
        if(i1+1 < n){
            ans += arr[i1+1][i2];
        }
        
        if(i2-1 >=0){
            ans += arr[i1][i2-1];
        }
        
        if(i2 + 1 <n){
            ans += arr[i1][i2+1];
        }
        return ans;
    }
    
    public int diagonalSum(int value) {
        int ans =0;
        int i=0;
        int j=0;
        
        for(int k=0;k<n;k++){
            for(int l=0;l<n;l++){
                if(arr[k][l] == value){
                    i=k;
                    j=l;
                    break;
                }
            }
        }
        
        if(i==n){
            return 0;
        }
        
        if(i-1 >=0 && j-1 >=0){
            ans+= arr[i-1][j-1];
        }
        
        if(i-1 >=0 && j+1<n){
            ans += arr[i-1][j+1];
        }
        
        if(i+1 < n && j-1 >=0){
            ans += arr[i+1][j-1];
        }
        
        if(i+1 < n && j+1 < n){
            ans += arr[i+1][j+1];
        }
        
        return ans;
        
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */