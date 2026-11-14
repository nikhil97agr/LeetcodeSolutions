class Solution {
    public int maxFrequency(int[] nums, int k, int op) {
        Map<Integer,Integer>freq = new HashMap<>();
        TreeMap<Integer, Integer> range = new TreeMap<>();
        for(int x : nums){
            freq.merge(x, 1, Integer::sum);
            range.put(x, 0);
        }

        for(int key : freq.keySet()){
            int start = key - k;
            int end = key + k + 1;
            range.merge(start, freq.get(key), Integer::sum);
            range.merge(end, -freq.get(key), Integer::sum);
        }
        int ans = 0;
        int cnt = 0;
        for(int key : range.keySet()){
            int val = range.get(key);
            cnt += val;
            if(freq.containsKey(key)){
                int left = cnt - freq.get(key);

                ans = Math.max(ans, Math.min(op, left) + freq.get(key));
            }else{
                ans = Math.max(ans, Math.min(op, cnt));
            }
        }

        return ans;
    }
}