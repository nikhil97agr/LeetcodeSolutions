class Solution {
    public int minOperations(int[] nums) {
        int dup = 0;
        int ans = 0;
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums){
            map.merge(x, 1, Integer::sum);
            if(map.get(x) == 2){
                dup++;
            }
        }

        for(int i=0;dup > 0 && i<n;i+=3){
            ans++;
            map.merge(nums[i], -1, Integer::sum);
            if(map.get(nums[i]) == 1)dup--;
            if(i+1 < n){
                map.merge(nums[i+1], -1, Integer::sum);
                if(map.get(nums[i+1]) == 1) dup--;
            }

            if(i+2 < n){
                map.merge(nums[i+2], -1, Integer::sum);
                if(map.get(nums[i+2]) ==1) dup--;
            }
        }

        return ans;
    }
}