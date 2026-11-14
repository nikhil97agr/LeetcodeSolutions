package count_the_digits_that_divide_a_number_2608;

class Solution {
    public int countDigits(int num) {
        int temp = num;
        int count = 0;
        while(temp>0){
            int x = temp%10;
            temp/=10;
            if(num%x==0){
                count++;
            }
        }
        return count;
    }
}