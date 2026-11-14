class Solution {
    public int numSubmat(int[][] mat) {
        int ans = 0;
        int n = mat.length;
        int m = mat[0].length;
        

        for(int i=0;i<n;i++){
            int cnt[] = new int[m];
            Arrays.fill(cnt, 1);
            for(int j=i;j<n;j++){
                for(int k=0;k<m;k++){
                    cnt[k] = cnt[k] & mat[j][k];
                }
                ans += get(cnt);
            }
        }
        return ans;
    }

    private int get(int cnt[]){
        int ans = 0;

        int  c = 0;
        for(int i=0;i<cnt.length;i++){
            if(cnt[i] == 0) c=0;
            else c++;

            ans += c;
        }

        return ans;
    }
}
