class Solution {
    public int captureForts(int[] forts) {
        int ans = 0;
        int n = forts.length;
        for(int i=0;i<n;i++){

            if(forts[i]!=1) continue;
            int cnt = 0;
            int j = i+1;
            while(j < n && forts[j] ==0){
                cnt++;
                j++;
            }

            if(j!=n && forts[j] != 1){
                ans = Math.max(ans, cnt);
            }
            cnt = 0;
            j = i-1;
            while(j>=0 && forts[j]== 0){
                j--;
                cnt++;
            }

            if(j>=0 && forts[j]!=1){
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}