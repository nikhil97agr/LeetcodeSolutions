package sum_of_elements_with_frequency_divisible_by_k_4068;

class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        int cnt[] = new int[101];
        for(int x : nums) cnt[x]++;

        int sum = 0;
        for(int i=0;i<=100;i++){
            if(cnt[i]%k==0){
                sum += i*cnt[i];
            }
        }

        return sum;
    }
}