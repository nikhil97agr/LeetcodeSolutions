package sum_of_numbers_with_units_digit_k_1334;

class Solution {
    public int minimumNumbers(int num, int k) {
        if(num == 0 )return 0;
        int x = 1;
        int dig = num%10;
        while(x<=10){
            if((x*k)%10 == dig){
                break;
            }
            x++;

        }
        if(x==11) return -1;
        if(k*x > num) return -1;
        return x;
    }
}