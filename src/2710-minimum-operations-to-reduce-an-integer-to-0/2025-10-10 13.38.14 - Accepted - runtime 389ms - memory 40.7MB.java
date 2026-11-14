class Solution {
    public int minOperations(int n) {
        int ans = Integer.MAX_VALUE;

        for(int i=0;i+n<=(2*n);i++){
            ans = Math.min(ans, calc(i)+ calc(n+i));
        }

        return ans;
    }

    private int calc(int n){
        int cnt = 0;
        while(n > 0){
            int pow = (int)(Math.log(n)/Math.log(2));

            n -= (1<<pow);
            cnt++;
        }

        return cnt;
    }
}