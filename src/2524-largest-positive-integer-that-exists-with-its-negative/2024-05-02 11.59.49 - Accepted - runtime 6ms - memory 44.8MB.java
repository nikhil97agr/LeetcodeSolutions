class Solution {
    public int findMaxK(int[] nums) {
        int ans = Integer.MIN_VALUE;;
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        for(int x : nums){
            if(set.contains(-x)){
                ans = Math.max(ans, x);
            }
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}