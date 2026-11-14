class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int total = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long diff = 1l*nums[j] - 1l*nums[i];
                total += solve(j, j+1, n, nums, diff, map);
            }
        }

        return total;
    }

    public int solve(int i, int j, int n, int nums[], long diff, Map<Integer, Integer> dp){
        if(j==n) return 0;

        int hash = new Pair(i, diff).hashCode();
        if(dp.containsKey(hash)){
            return dp.get(hash);
        }
        int ans = 0;
        for(;j<n;j++){
            long d = 1l*nums[j] - 1l*nums[i];
            if(d == diff){
                ans += 1 + solve(j, j+1, n, nums, diff, dp);
            }
        }
        dp.put(hash, ans);
        return ans;
    }

    class Pair{
        long diff;
        int ind;

        public Pair(int ind, long diff){
            this.ind = ind;
            this.diff = diff;
        }


        public int hashCode(){
            return (""+diff+":"+ind).hashCode();
        }
    }
}