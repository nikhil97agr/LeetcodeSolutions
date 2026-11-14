class Solution {
    public long coloredCells(int n) {
        if(n==1){
            return 1l;
            
        }
        if(n==2){
            return 5l;
        }
        
        long ans =5l;
        long prev = 0;
        for(long i=3;i<=1l*n;i++){
            ans += 1l*8 + prev;
            prev+=4;
        }
        return ans;
    }
}