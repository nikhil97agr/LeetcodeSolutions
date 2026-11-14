class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> one = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        Map<Integer, Integer> lost = new HashMap<>();
        for(int m[] : matches){
            lost.put(m[0], lost.getOrDefault(m[0],0));
            lost.put(m[1], lost.getOrDefault(m[1],0)+1);
        }

        for(Map.Entry<Integer, Integer>entry : lost.entrySet()){
            if(entry.getValue()==0) zero.add(entry.getKey());
            if(entry.getValue()==1) one.add(entry.getKey());
        }

        Collections.sort(one);
        Collections.sort(zero);
        List<List<Integer>> res = new ArrayList<>();
        res.add(zero);
        res.add(one);
        return res;
    }
}