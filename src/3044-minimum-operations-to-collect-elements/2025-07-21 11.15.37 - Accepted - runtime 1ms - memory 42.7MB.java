class Solution {
    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        for(int i=nums.size()-1;i>=0 && set.size() < k;i--){
            if(nums.get(i) <= k)
            set.add(nums.get(i));
            ans++;
        }

        return ans;
    }
}