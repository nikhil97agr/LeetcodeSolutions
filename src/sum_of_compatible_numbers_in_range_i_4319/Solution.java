package sum_of_compatible_numbers_in_range_i_4319;

class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int ans = 0;
        for(int x=1;x<=500;x++){
            if(Math.abs(n-x) <= k && (n&x)==0){
                ans+=x;
            }
        }

        return ans;
    }
}