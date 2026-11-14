class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        var map = new HashMap<Integer, State>();
        int n = nums.length;

        int start = 0;
        int end = 0;
        int ans = 1;

        while (end < n) {
            int val = nums[end];
            var state = map.get(val);
            if (state == null) {
                state = new State();
                map.put(val, state);
            }

            if(state.cnt < k){
                state.cnt++;
            }
            else{
                int v = 0;
                while((v = nums[start++]) != val){
                    map.get(v).cnt--;
                }
            }
            

            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;

    }

    class State {
        int cnt = 0;
    }
}