class Solution {
    public void wiggleSort(int[] nums) {
        int cnt[] = new int[Arrays.stream(nums).max().getAsInt()+1];
        int last = cnt.length-1;
        int n = nums.length;
        for(int x : nums) cnt[x]++;
        for(int i=1;i<n;i+=2){
            while(cnt[last] ==0) last--;
            nums[i] = last;
            cnt[last]--;
        }

        for(int i=0;i<n;i+=2){
            while(cnt[last]==0) last--;
            nums[i] = last;
            cnt[last]--;
        }


    }
}