class Solution {
    public int valueAfterKSeconds(int n, int k) {
        long mod = (long)1e9+7;
        long ans = 0;
        
        long num[] = new long[n];
        Arrays.fill(num, 1);
        while(k>0){
            for(int i=1;i<n;i++){
               num[i] = num[i] + num[i-1];
                num[i]%=mod;
            }
            k--;
        }
        
        return (int)num[n-1];
        
    }
}