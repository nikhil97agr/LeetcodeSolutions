class Solution {
    public boolean sumOfNumberAndReverse(int n) {
       for(int i=0;i<=n;i++){
        int x = i;
        int y = 0;
        while(x > 0){
            int dig = x%10;
            y = y*10 + dig;
            x/=10;
        }

        if(i+y==n) return true;
       } 
       return false;
    }
}