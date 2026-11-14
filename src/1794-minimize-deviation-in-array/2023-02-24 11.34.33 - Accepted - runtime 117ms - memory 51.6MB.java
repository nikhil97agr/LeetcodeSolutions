class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int x : nums){
            if((x&1)==1){
                set.add(x<<1);

            }else{
                set.add(x);
            }
        }
        int ans = Integer.MAX_VALUE;

        while(true){
            int x = set.last();

            ans = Math.min(ans, x - set.first());

            if((x&1)==0){
                set.remove(x);
                set.add(x>>1);
            }else{
                return ans;
            }
        }
    }
}