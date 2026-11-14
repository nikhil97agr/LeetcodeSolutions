class Solution {
    public int firstUniqueFreq(int[] nums) {
        int cnt[] = new int[Arrays.stream(nums).max().getAsInt()+ 1];
        for(int x : nums){
            cnt[x]++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : cnt) map.merge(x, 1, Integer::sum);
        for(int x : nums){
            int c = cnt[x];
            if(map.get(c) ==1) return x;
        }
        return -1;
    }


}