class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char res[][] = new char[n][m];
        for(char []c: res){
            Arrays.fill(c, '.');
        }
        int col = 0;
        for(int i=0;i<m;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(boxGrid[i][j] == '#'){
                    cnt++;
                }else if(boxGrid[i][j] == '*'){
                    for(int k=j-1;k>=0 && cnt >0;k--, cnt--){
                        res[k][m-i-1] = '#';
                    }
                    res[j][m-i-1] = '*';
                }
            }

            if(cnt > 0){
                for(int j=n-1;j>=0 && cnt > 0;j--,cnt--){
                    res[j][m-i-1] = '#';
                }
            }
        }

        return res;
    }
}