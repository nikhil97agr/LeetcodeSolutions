class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0;
        int diag = 0;
        
        for(int x[] : dimensions){
            int len = x[0];
            int w = x[1];
            int di = len*len + w*w;
            if(diag == di){
                ans = Math.max(ans, len*w);
            }else if(di > diag){
                ans = len * w;
                diag = di;
            }
        }
        return ans;
    }
}