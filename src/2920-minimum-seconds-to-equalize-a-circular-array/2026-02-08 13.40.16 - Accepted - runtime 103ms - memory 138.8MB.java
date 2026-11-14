class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums.get(i), x-> new ArrayList<>()).add(i);
        }

        for(int key : map.keySet()){
            List<Integer> list = map.get(key);
            int start = list.get(0);
            int end = n - 1- list.get(list.size() - 1);
            int res = (start + end + 1)/2;

            for(int i=1;i<list.size();i++){
                int len = list.get(i) - list.get(i-1);
                len/=2;
                res= Math.max(res, len);
            }
            ans = Math.min(ans, res);

        }
        return ans;
    }
}