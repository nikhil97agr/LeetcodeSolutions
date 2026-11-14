class Solution {
    public long shadowPairs(int[] nums) {
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        for(int x : nums){
            while(!stack.isEmpty() && stack.peek() > x){
                int val = stack.pop();
                cnt--;
                map.merge(val, -1, Integer::sum);
                
            }


            ans += cnt - map.getOrDefault(x, 0);
            map.merge(x, 1, Integer::sum);
            cnt++;
            stack.push(x);
        }

        return ans;
    }
}