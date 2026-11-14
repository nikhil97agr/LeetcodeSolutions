class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int val = nums[i];
            map.computeIfAbsent(val, x-> new ArrayList<>()).add(i);
        }

        for(List<Integer> list: map.values()){
            for(int c=2;c<list.size();c++){
                int i =list.get(c-2);
                int j = list.get(c-1);
                int k= list.get(c);

                ans = Math.min(ans, Math.abs(i-j) + Math.abs(i-k) + Math.abs(j-k));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}