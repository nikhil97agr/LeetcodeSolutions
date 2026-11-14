package find_the_sum_of_encrypted_integers_3367;

class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int ans = 0;
        for(int x : nums){
            int temp = x;
            int max = 0;
            while(temp  > 0){
                max = Math.max(temp%10, max);
                temp/=10;
            }
            int num = 0;
            temp = x;
            while(temp > 0){
                temp/= 10;
                num = num*10 + max;
            }
            ans += num;
        }
        return ans;
    }
}