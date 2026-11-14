class Matrix3D {
    int cnt[];
    int mat[][][];
    public Matrix3D(int n) {
        cnt = new int[n];
        mat = new int[n][n][n];
    }
    
    public void setCell(int x, int y, int z) {
        if(mat[x][y][z] == 1) return;
        cnt[x]++;
        mat[x][y][z] = 1;
    }
    
    public void unsetCell(int x, int y, int z) {
        if(mat[x][y][z] == 0) return;

        cnt[x]--;
        mat[x][y][z]= 0;
    }
    
    public int largestMatrix() {
        int cnt = 0;
        int ans = this.cnt[0];
        for(int i=0;i<this.cnt.length;i++){
            if(this.cnt[i] >=cnt){
                cnt =this.cnt[i];
                ans = i;
            }
        }

        return ans;
    }
}

/**
 * Your Matrix3D object will be instantiated and called as such:
 * Matrix3D obj = new Matrix3D(n);
 * obj.setCell(x,y,z);
 * obj.unsetCell(x,y,z);
 * int param_3 = obj.largestMatrix();
 */