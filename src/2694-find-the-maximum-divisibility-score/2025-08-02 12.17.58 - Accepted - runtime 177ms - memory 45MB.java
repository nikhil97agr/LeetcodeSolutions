class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        Map<Integer, Integer> score= new HashMap<>();
        int cnt = -1;
        int ans = -1;
        for(int y : divisors){
            int c = 0;
            for(int x : nums){
                if(x%y==0){
                    c++;
                }
            }

            if(c > cnt){
                ans = y;
                cnt = c;
            }else if(c ==cnt){
                if(ans > y) ans = y;
            }
        }
        return ans;
    }
}