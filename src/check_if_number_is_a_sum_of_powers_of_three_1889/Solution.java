package check_if_number_is_a_sum_of_powers_of_three_1889;

class Solution {
    public boolean checkPowersOfThree(int n) {
        int max = (int)(Math.log(n)/Math.log(3))+1;

        while(n > 0 && max >= 0){
            int val = (int)Math.pow(3, max);
            if(n >= val){
                n -= val;
            }

            max--;
        }


        return n==0;
    }
}