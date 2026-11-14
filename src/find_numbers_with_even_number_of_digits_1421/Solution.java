package find_numbers_with_even_number_of_digits_1421;

class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int x :nums){
            if(new StringBuilder(""+x).length()%2==0) ans++;
        }
        return ans;
    }
}