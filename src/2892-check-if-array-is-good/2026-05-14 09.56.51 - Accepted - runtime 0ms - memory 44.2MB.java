class Solution {
    public boolean isGood(int[] nums) {
        int len = nums.length;
        int cnt[] = new int[len];
        for(int x : nums){
            if(x >= len) return false;
             cnt[x]++;
        }

        if(cnt[len-1] !=2) return false;

        for(int i=1;i<len-1;i++){
            if(cnt[i]!=1) return false;
        }

        return true;
    }
}