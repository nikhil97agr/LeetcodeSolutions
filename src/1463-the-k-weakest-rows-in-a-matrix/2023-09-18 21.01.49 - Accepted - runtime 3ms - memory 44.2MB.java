class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int cnt[] = new int[n];
        int weaks[][] = new int[n][2];
        for(int i=0;i<n;i++){
            weaks[i][1] = i;
            for(int x : mat[i]){
                if(x==1) cnt[i]++;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(cnt[i]<=cnt[j]){
                    weaks[i][0]++;
                }else{
                    weaks[j][0]++;
                }
            }
        }


        Arrays.sort(weaks, (a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0] - a[0];
        });
        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = weaks[i][1];
        }
        return ans;
    }
}