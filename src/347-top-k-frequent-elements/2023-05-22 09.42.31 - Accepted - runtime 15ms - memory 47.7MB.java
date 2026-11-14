class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        int ans[] = new int[k];
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a,b)->{
            return b.getValue() - a.getValue();
        });
        int i =0;
        for(Map.Entry<Integer, Integer> entry : list){
            if(i==k){
                break;
            }

            ans[i++] = entry.getKey();
        }
        return ans;
    }
}