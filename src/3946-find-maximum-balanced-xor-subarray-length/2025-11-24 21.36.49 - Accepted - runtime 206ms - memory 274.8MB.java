class Solution {
    public int maxBalancedSubarray(int[] nums) {
        Map<Pair, Integer> map = new HashMap<>();

        int ans =0 ;
        map.put(new Pair(0, 0), -1);

        int e = 0;
        int o = 0;
        int xor = 0;

        for(int i=0;i<nums.length;i++){
            int x = nums[i];

            if(x%2==0) e++;
            else o++;

            xor ^= x;

            Pair pair = new Pair(xor, e- o);

            if(map.containsKey(pair)){
                ans = Math.max(ans, i - map.get(pair));
            }else{
                map.put(pair, i);
            }
        }

        return ans;
    }

    class Pair{
        int xor;
        int diff;

        public Pair(int xor, int diff){
            this.xor = xor;
            this.diff = diff;
        }

        public boolean equals(Object ob){
            Pair pair = (Pair) ob;

            return pair.diff ==diff && pair.xor == xor;
        }

        public int hashCode(){
            return Objects.hash(xor, diff);
        }
    }
}