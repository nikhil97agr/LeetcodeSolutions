class Solution {
    public int findNonMinOrMax(int[] nums) {
        int n = nums.length;
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        for(int x : nums){
            if(min!=x && max!=x) return x;
        }
        return -1;
    }
}