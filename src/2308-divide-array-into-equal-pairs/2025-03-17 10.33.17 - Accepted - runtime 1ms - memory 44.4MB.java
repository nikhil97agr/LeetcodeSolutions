class Solution {
    public boolean divideArray(int[] nums) {
        int cnt[] = new int[501];
        for(int x : nums) cnt[x]++;

        for(int y : cnt){
            if(y%2==1) return false;
        }
        return true;
    }
}