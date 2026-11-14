package string_transformation_3024;

class Solution {
    int mod = 1_000_000_007;
    public int numberOfWays(String s, String t, long k) {
        var totalMatch = rotated(s, t);
        var n = s.length();
        if(totalMatch == 0) return 0;

        int mat[][] = { {totalMatch-1, totalMatch},{ n - totalMatch, n - totalMatch - 1} };

        mat= exp(mat, k);

        if(s.equals(t)) return mat[0][0];

        return mat[0][1];
    }

    private int[][] exp(int mat[][], long k){
        var n = mat.length;
        var res = new int[n][n];
        for(var i=0;i<n;i++){
            res[i][i] = 1;
        }

        while( k > 0){
            if(k%2==1){
                res = prod(res, mat);
            }

            mat = prod(mat, mat);

            k >>= 1;
        }
        
        return res;
    }

    private int[][] prod(int a[][], int b[][]){
        var rA = a.length;
        var cB = b[0].length;
        var cA = a[0].length;
        var res = new int[rA][cB];

        for(var i=0;i<rA;i++){
            for(var j=0;j<cB;j++){
                for(var k=0;k<cA;k++){
                    res[i][j] = add(res[i][j], prod(a[i][k], b[k][j]));
                }
            }
        }

        return res;


    }

    private int add(long a, long b){
        return (int)((1l*a+b)%mod);
    }
    
    private int prod(long a, long b){
        return (int)((1l * a * b)%mod);
    }

    private int rotated(String s, String t){
        var lps = lps(t.toCharArray());
        var matchingIndices = 0;
        var n = t.length();
        s = s + s;
        var i=0;
        var j=0;
        while( i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
                if(j == t.length()){
                    if(i - n <n){
                        matchingIndices++;
                    }
                    j = lps[j-1];
                }
            }else{
                if(j==0){
                    i++;
                }else{
                    j = lps[j-1];
                }
            }
        }

        return matchingIndices;
    }

    private int[] lps(char ch[]){
        var n = ch.length;
        var lps = new int[n];
        var i=1;
        var len = 0;
        while( i < n){
            if(ch[i] == ch[len]){
                len++;

                lps[i] =len;
                i++;
            }else{
                if(len ==0){
                    i++;
                }else{
                    len = lps[len - 1];
                }
            }
        }

        return lps;
    }
}