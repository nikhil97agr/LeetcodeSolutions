class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        int ans[] = new int[n];

        List<Map.Entry<Integer, Integer>> entry = new ArrayList<>(map.entrySet());
        Collections.sort(entry,(e1, e2)->{
            if(e1.getValue() == e2.getValue()) return e2.getKey() - e1.getKey();
            return e1.getValue() - e2.getValue();
        } );

        int i=0;
        for(Map.Entry<Integer, Integer> e : entry){
            for(int j=0;j<e.getValue();j++){
                ans[i++] = e.getKey();
            }
        }

        return ans;
    }
}