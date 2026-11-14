class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for(int p[] : properties){
            map.computeIfAbsent(p[0], x-> new ArrayList<>()).add(p[1]);
        }

        List<Integer> key = new ArrayList<>(map.keySet());

        int ans = 0;
        int max = 0;
        for(int i=key.size() -1 ;i>=0;i--){
            int newMax= 0;
            for(int x : map.get(key.get(i))){
                if(x < max){
                    ans++;
                }

                newMax = Math.max(newMax, x);
            }

            max = Math.max(max, newMax);
        }

        return ans;

    }
}