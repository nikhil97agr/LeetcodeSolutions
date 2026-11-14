class Solution {
    public long countCommas(long n) {
        long ans = 0;
        if( n< 1000) return 0;
        int maxlen = Long.toString(n).length();
        for(int i=4;i<maxlen;i++){
            long nums = (long)Math.pow(10l, i ) - (long)Math.pow(10l, i-1);
            long dig = i / 3;
            if(i%3==0){
                dig--;
            }
            ans += nums * dig;
        }
        
        long left = n - (long)Math.pow(10, maxlen- 1) + 1;
        
        long total = maxlen / 3;
        if(maxlen%3==0){
            total--;
        }
        
        return ans + total * left;
        
    }
}