package number_of_steps_to_reduce_a_number_to_zero_1444;

class Solution {
    public int numberOfSteps(int num) {
        int ans = 0;
        while(num > 0){
            while(num > 0 && num%2==0){
                num /=2;
                ans++;
            }
            if(num > 0){
                num--;
                ans++;
            }
        }

        return ans;
    }
}