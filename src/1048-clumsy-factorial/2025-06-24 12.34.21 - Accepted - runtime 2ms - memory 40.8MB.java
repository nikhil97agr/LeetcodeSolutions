class Solution {
    public int clumsy(int n) {
        int ans = 0;

        for(int i=n-3;i>0;i-=4){
            ans += i;
            
        }
        for(int i=n;i>0;i-=4){
            int a = i;
            int b = i-1 <= 0 ? 1: i-1;
            int c = i-2 <= 0 ? 1 : i-2;
            if(i==n){

                ans += (a*b)/c;
            }else{
                ans -= (a*b)/c;
            }
        }

        return ans;
    }
}