class Solution {
    public int tribonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        if(n==0){
            return a;
        }
        if(n==1){
            return b;
        }
        if(n==2){
            return c;
        }

        for(int i=3;i<=n;i++){
            int temp = a;
            a = b;
            b = c;
            c = a + b + temp;
        }

        return c;


        
    }
}