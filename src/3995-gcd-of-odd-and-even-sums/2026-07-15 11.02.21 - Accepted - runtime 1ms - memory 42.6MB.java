class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odd = 0;
        int even = 0;

        int cnt = 0;
        for(int i=1;cnt < n;i+=2){
            odd += i;
            cnt++;
        }

        cnt = 0;
        for(int i=2;cnt < n;i+=2){
            even += i;
            cnt++;
        }

        return gcd(odd, even);
    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}