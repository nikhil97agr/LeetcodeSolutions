class Solution {
    public int maximumSum(int[] nums) {
        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums){
            int y = x;
            int sum =0;
            while(x>0){
                sum += x%10;
                x/=10;
            }

            if(map.containsKey(sum)){
                int val = map.get(sum);
                ans = Math.max(ans, y+val);
                map.put(sum, Math.max(val, y));
            }else{
                map.put(sum ,y);
            }
        }
        return ans;
    }
}