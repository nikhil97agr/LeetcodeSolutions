class Solution {
    public boolean canAliceWin(int[] nums) {
        int sum1 = Arrays.stream(nums).filter(n -> n < 10).sum();
        int sum2 = Arrays.stream(nums).filter(n -> n>=10).sum();
        return sum1 != sum2;
    }
}