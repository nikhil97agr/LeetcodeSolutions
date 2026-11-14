package check_divisibility_by_digit_sum_and_product_3918;

class Solution {
    public boolean checkDivisibility(int n) {
        int prod = 1;
        int sum = 0;
        int temp = n;
        while( n > 0){
            int dig = n%10;
            sum += dig;
            prod *= dig;
            n/=10;
        }


        return temp%(sum + prod) == 0;
    }
}