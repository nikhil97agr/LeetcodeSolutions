class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums){
            if(x >= 0){
                map.merge(x%value, 1, Integer::sum);
            }else{
                int mod = Math.abs(x)%value;
                int left = value - mod;
                map.merge(left%value, 1, Integer::sum);
            }

        }

        Set<Integer> set = new HashSet<>();
        for(int key : map.keySet()){
            int val = map.get(key);
            

            for(int i=0;i<val;i++){
                set.add( key + i * value);
            }
        }

        int ans = 0;
        while(set.contains(ans)) ans++;
        return ans;
    }
}