package subtract_the_product_and_sum_of_digits_of_an_integer_1406;

class Solution {
    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        while(n>0){
            int digit = n%10;
            prod*=digit;
            sum+=digit;
            n/=10;
        }

        return prod-sum;
    }
}