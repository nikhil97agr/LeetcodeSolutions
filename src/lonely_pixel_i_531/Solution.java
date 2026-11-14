package lonely_pixel_i_531;

class Solution {
    public int findLonelyPixel(char[][] arr) {
        int ans = 0;
        int n = arr.length;
        int m = arr[0].length;

        int row[] = new int[n];
        int col[] = new int[m];

        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<m;j++){
                if(arr[i][j] == 'B'){
                    cnt++;
                }
            }
            row[i] = cnt;
        }
        for(int i=0;i<m;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(arr[j][i] == 'B'){
                    cnt++;
                }
            }
            col[i] = cnt;
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 'B' && row[i] == 1 && col[j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
}