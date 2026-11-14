class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int mod = (int)1e9 + 7;

        int inc[] = new int[r+2];
        int dec[] = new int[r+2];

        // base case
        for(int j=l;j<=r;j++){
            inc[j] = 1;
            dec[j] = 1;
        }

        for(int i=1;i<n;i++){
            int preDec[] = new int[r+2]; // prefix of dec
            int preInc[] = new int[r+2]; // suffix of inc

            // prefix sum of dec
            for(int j=l;j<=r;j++){
                preDec[j] = (preDec[j-1] + dec[j]) % mod;
            }

            // suffix sum of inc
            for(int j=r;j>=l;j--){
                preInc[j] = (preInc[j+1] + inc[j]) % mod;
            }

            int newInc[] = new int[r+2];
            int newDec[] = new int[r+2];

            for(int j=l;j<=r;j++){
                newInc[j] = preDec[j-1]; // from smaller
                newDec[j] = preInc[j+1]; // from greater
            }

            inc = newInc;
            dec = newDec;
        }

        int ans = 0;
        for(int j=l;j<=r;j++){
            ans = ((ans + inc[j])%mod + dec[j]) % mod;
        }

        return ans;
    }
}