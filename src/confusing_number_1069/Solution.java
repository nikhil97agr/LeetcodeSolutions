package confusing_number_1069;

class Solution {
    public boolean confusingNumber(int n) {
        int num = n;

        int next = 0;
        while(num > 0){
            int dig = num%10;

            if(dig == 0 || dig == 1 || dig == 8 ){
                next = next*10 + dig;
            }else if(dig == 9){
                next = next*10 + 6;
            }else if(dig == 6){
                next =next*10 + 9;
            }else{
                return false;
            }
            num/=10;
        }

        return next != n;
    }
}