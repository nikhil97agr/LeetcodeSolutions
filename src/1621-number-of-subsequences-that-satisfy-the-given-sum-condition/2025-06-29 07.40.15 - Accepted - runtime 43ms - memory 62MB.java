class Solution {
    public int numSubseq(int[] nums, int target) {
        long total = 0;
        long mod = (long)1e9+7;
        int n = nums.length;
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0l,1l);
        long cnt = 1;
        for(long i=1;i<=n;i++){
            cnt = cnt*2;
            cnt %=mod;
            map.put(i, cnt);

        }
        Arrays.sort(nums);
        int start = 0;
        int end = n-1;
        while(start<=end){
            if(nums[start]+nums[end]<=target){
                total = total + map.get(1l*(end-start));
                total%=mod;
                start++;
            }else{
                end--;
            }
        }
        return (int)total;
    }
}