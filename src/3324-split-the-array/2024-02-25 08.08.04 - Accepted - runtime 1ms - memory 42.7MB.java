class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int cnt[] = new int[101];
        for(int x : nums){
            cnt[x]++;
        }
        for(int x : cnt) if(x > 2) return false;
        return true;
    }
}