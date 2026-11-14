package smallest_divisible_digit_product_i_3626;

class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int prod = prod(n);
            if(prod %t==0) return n;
            n++;
        }

        
    }

    private int prod(int n){
        int ans = 1;
        while(n > 0){
            ans *= n%10;
            n/=10;
        }

        return ans;
    }
}