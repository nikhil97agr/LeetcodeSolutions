class Solution {
    public String[] createGrid(int m, int n) {
        char res[][] = new char[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(res[i], '#');
        }

        for(int i=0;i<n;i++){
            res[0][i] = '.';
        }

        for(int j=0;j<m;j++){
            res[j][n-1] = '.';
        }

        return Arrays.stream(res).map(x -> new String(x)).toArray(String[]::new);
    }
}