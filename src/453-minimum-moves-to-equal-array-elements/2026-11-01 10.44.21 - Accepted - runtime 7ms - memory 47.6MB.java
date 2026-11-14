class Solution {
    public int minMoves(int[] nums) {
        int ans = 0;
        int min = Arrays.stream(nums).min().getAsInt();

        for(int x : nums){
            ans += x - min;
        }

        return ans;
    }
}