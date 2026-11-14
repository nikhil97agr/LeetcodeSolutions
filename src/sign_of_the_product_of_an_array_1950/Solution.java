package sign_of_the_product_of_an_array_1950;

class Solution {
    public int arraySign(int[] nums) {
        int cnt = 0;
        for(int x : nums){
            if(x==0){
                return 0;
            }

            if(x<0){
                cnt++;
            }
        }
        return cnt%2==0 ? 1 : -1;
    }
}