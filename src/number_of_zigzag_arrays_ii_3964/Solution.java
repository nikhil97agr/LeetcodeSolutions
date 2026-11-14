package number_of_zigzag_arrays_ii_3964;

class Solution {
    int mod = 1_000_000_007;
    public int zigZagArrays(int n, int l, int r) {
        int len = r - l + 1;
        if( n==1) return len;
        int mat[][] = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i + j >= len){
                    mat[i][j] = 1;
                }
            }
        }

        mat = pow(mat, n -1, len);
        int ans = 0;
        for(var x : mat){
            for(var y : x){
                ans = add(ans, y);
            }
        }

        return prod(ans, 2);
    }

    private int [][] mult(int m1[][], int m2[][], int len){
        int res[][] = new int[len][len];
        for(int i=0;i<len;i++){
            for(int k=0;k<len;k++){
                for(int j=0;j<len;j++){
                    res[i][j] = add(res[i][j], prod(m1[i][k], m2[k][j]));
                }
            }
        }

        return res;
    }

    private int[][] pow(int mat[][], int p, int len){
        int ans[][] = new int[len][len];
        for(int i=0;i<len;i++) ans[i][i] = 1;

        while( p > 0){
            if(p%2==1){
                ans = mult(ans, mat, len);
            }
            mat = mult(mat, mat, len);

            p>>=1;
        }

        return ans;
    }

    public int add(int a, int b){
        long total = 1l * a + b;
        return (int)(total%mod);
    }

    public int prod(int a, int b){
        long p = 1l * a *b;
        return (int)(p %mod);
    }
}
