class Solution {
    public int consecutiveNumbersSum(int n) {
        int ans = 0;
        for(int i=1;i<=Math.min(n, 100000);i++){
            if((n*2)%i==0){
                int a = (n * 2)/i + 1 - i;
                if(a%2==0){
                    a/=2;
                    if(a > 0)ans++;
                }
            }
        }

        return ans;
    }
}

/**
    Sn = n/2 * (2*a + n-1)
    => (Sn * 2)/n + 1 - n = a

 */