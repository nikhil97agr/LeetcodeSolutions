package number_of_common_factors_2507;

class Solution {
    public int commonFactors(int a, int b) {
        int gcd = gcd(a,b);

        int cnt = 0;
        for(int i=1;i<=Math.sqrt(gcd);i++){
            if(gcd%i==0){
                if(gcd/i==i) cnt++;
                else cnt+=2;
            }
        }

        return cnt;
    }

    private int gcd(int a, int b){
        if(b==0) return a;

        return gcd(b, a%b);
    }
}