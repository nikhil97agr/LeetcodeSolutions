class Solution {
    public int partitionArray(int[] nums, int k) {
        int ans = 1;
        TreeSet<Integer> set = new TreeSet<>();
        for(int x : nums) set.add(x);
        int min = (int)1e6;
        int max = 0;
        for(int x : set){
            min = Math.min(min, x);
            max = Math.max(max, x);

            if(max -min  > k){
                ans++;
                min = x;
                max = x;
            }
        }

        return ans;
    }
}