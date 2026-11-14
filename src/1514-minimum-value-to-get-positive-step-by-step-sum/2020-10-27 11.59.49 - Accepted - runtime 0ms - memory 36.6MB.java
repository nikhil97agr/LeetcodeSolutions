class Solution {
    public int minStartValue(int[] nums) {
        int prefix = Integer.MAX_VALUE;
        int total = 0;
        for(int x : nums)
        {
            total += x;
            prefix = Math.min(prefix, total);
        }
        if(prefix>0)
            return 1;
        return -1*prefix + 1;
    }
}