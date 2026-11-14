class Solution {
    public long sumDigitDifferences(int[] nums) {
        int len = 0;
        int x = nums[0];
        long ans = 0;
        while(x > 0){
            x/=10;
            len++;
        }
        Map<Integer, Long> map[] = new HashMap[len];
        for(int i=0;i<len;i++){
            map[i] = new HashMap<>();
        }
        int n = nums.length;
        for(int i=0;i<n;i++){
            int ind = len-1;
            int temp = nums[i];
            while(temp > 0){
                int dig = temp%10;
                temp/=10;
                long cnt= map[ind].getOrDefault(dig, 0L);
                ans += (1L*i - cnt);
                ind--;
            }
            ind = len - 1;
            while(nums[i] > 0){
                int dig = nums[i]%10;
                nums[i] /= 10;
                
                long cnt = map[ind].getOrDefault(dig, 0L);
                map[ind].put(dig, cnt+1);
                ind--;
            }
        }
        return ans;
    }
}