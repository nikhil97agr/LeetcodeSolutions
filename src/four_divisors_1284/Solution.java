package four_divisors_1284;

class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            ans += calc(nums[i]);
        }
        return ans;
    }

    private int calc(int n){
        int sum = 0;
        int cnt = 0;
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                int x = n/i;
                if(x== i){
                    sum += i;
                    cnt++;
                }else{
                    sum += x + i;
                    cnt+=2;
                }
            }
        }

        return cnt == 4 ? sum : 0;
    }

}