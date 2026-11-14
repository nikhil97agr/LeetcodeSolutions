class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int x[] : adjacentPairs){
            int f = x[0];
            int s = x[1];
            map.computeIfAbsent(f, e-> new HashSet<>()).add(s);
            map.computeIfAbsent(s, e-> new HashSet<>()).add(f);
        }
        int n = adjacentPairs.length+1;
        int ans[] = new int[n];
        int i = 0;
        int next= -1;
        for(int x : map.keySet()){
            if(map.get(x).size()==1){
                next = x;
                break;
            }
        }

        while(true){
            ans[i++] = next;
            if(map.get(next).size()==0) break;
            for(int y : map.get(next)){
                map.get(y).remove(next);
                next = y;
                break;
            }
        }
        return ans;

    }
}