package smallest_value_after_replacing_with_sum_of_prime_factors_2595;

class Solution {
    public int smallestValue(int n) {
        int ans = n;

        while(true){
            int next = get(n);
            
            if(next ==n )break;
            ans = Math.min(ans, next);
            n= next;
        }

        return ans;
    }

    private int get(int n){
        int ans = 0;

        while(n%2==0){
            n/=2;
            ans+=2;
        }

        for(int i=3;i<=Math.sqrt(n);i++){
            while(n%i==0){
                n/=i;
                ans+=i;
            }
        }

        if(n!=1){
            ans +=n;
        }
        return ans;
    }
}