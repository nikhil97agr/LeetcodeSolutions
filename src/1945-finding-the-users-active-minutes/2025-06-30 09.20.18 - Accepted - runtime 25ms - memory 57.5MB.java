class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
       int ans[] = new int[k];
        Map<Integer, Set<Integer>> map =new HashMap<>();
        for(int l[] : logs){
            int id = l[0];
            int t = l[1];
            map.computeIfAbsent(id, i-> new HashSet<>()).add(t);
        }
        Map<Integer, List<Integer>> m = new HashMap<>();

        for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()){
            int id = entry.getKey();
            int size= entry.getValue().size();
            m.computeIfAbsent(size, i-> new ArrayList<>()).add(id);
        }

        for(int i=1;i<=k;i++){
            ans[i-1] = m.getOrDefault(i, new ArrayList<>()).size();
        }
       return ans; 
    }
}