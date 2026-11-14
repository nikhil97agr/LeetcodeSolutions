class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            if(x >=0) set.add(x);
        }


        if(set.isEmpty()){
            int max = -101;
            for(int x : nums) max = Math.max(max, x);
            return max;
        }

        int ans = 0;
        for(int x : set) ans +=x;
        return ans;
    }
}