package maximum_product_of_two_digits_3859;

class Solution {
    public int maxProduct(int n) {
        int a = 0;
        int b = 0;
        while(n > 0){
            var dig = n%10;
            if( dig > a){
                b = a;
                a = dig;
            }else if(dig > b){
                b = dig;
            }
            n/=10;
        }


        return a * b;
    }
}