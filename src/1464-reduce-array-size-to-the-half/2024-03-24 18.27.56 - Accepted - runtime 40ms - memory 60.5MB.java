class Solution {
    public int minSetSize(int[] arr) {
        int ans = 0;
        int n = arr.length;
        int size = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr){
            int cnt = map.getOrDefault(x, 0);
            map.put(x, cnt+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (e1, e2)-> e2.getValue() - e1.getValue());
        for(Map.Entry<Integer, Integer> entry : list){
            if(size >= n/2)
            break;
            size += entry.getValue();
            ans++;
        }
        return ans;
    }
}