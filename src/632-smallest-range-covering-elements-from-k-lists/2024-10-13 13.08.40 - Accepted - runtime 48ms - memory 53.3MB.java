class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int start = -100000;
        int end = 100000;
        int diff = end - start;

        List<int[]> list = new ArrayList<>();
        for(int i=0;i<nums.size();i++){
            for(int x : nums.get(i)){
                list.add(new int[]{x, i});
            }
        }
        Collections.sort(list, (a,b)-> a[0] - b[0]);
        int n = list.size();
        int m = nums.size();
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        while(r < n){
            int p[] = list.get(r);
            add(p[1], map);
            add(p[0], tree);
            while(map.size() == m){
                int first = tree.firstKey();
                int last = tree.lastKey();

                if(last - first < diff){
                    start = first;
                    end = last;
                    diff = last - first;
                }
                p = list.get(l);
                remove(p[1], map);
                remove(p[0], tree);
                l++;
            }
            r++;
        }
        while(map.size() == m){
            int first = tree.firstKey();
            int last = tree.lastKey();

            if(last-first < diff){
                start = first;
                end = last;
                diff = last - first;
            }
            int p[] = list.get(l);
            remove(p[1], map);
            remove(p[0], tree);
            l++;
        }

        return new int []{start, end};
    }

    private void add(int val, Map<Integer, Integer> map ){
        map.put(val,map.getOrDefault(val, 0)+1);
    }

    private void remove(int val, Map<Integer, Integer> map){
        int cnt = map.get(val);

        if(cnt == 1)map.remove(val);
        else map.put(val, cnt - 1);
    }
}