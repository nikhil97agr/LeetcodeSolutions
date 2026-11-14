class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length;

        int pre[] = new int[n+1];
        int suf[] = new int[n+1];

        for(int i=1;i<=n;i++){
            pre[i] = pre[i-1] + (possible[i-1] == 0 ? -1 : 1);
        }
        
        for(int i=n-1;i>=0;i--){
            suf[i] = suf[i+1] + (possible[i] == 0 ? -1 : 1);
        }

        for(int i=1;i<n;i++){
            if(pre[i] > suf[i]) return i;
        }
        return -1;
    }
}