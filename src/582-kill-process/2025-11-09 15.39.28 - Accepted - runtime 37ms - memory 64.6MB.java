class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int p : pid) map.put(p, new ArrayList<>());
        for(int i=0;i<ppid.size();i++){
            if(ppid.get(i)!=0){
                int par = ppid.get(i);
                int child = pid.get(i);
                map.computeIfAbsent(par, x-> new ArrayList<>()).add(child);
            }
        }
        dfs( -1, map, kill, result);
    return result;
    }

    private void dfs(int par, Map<Integer, List<Integer>> map, int curr, List<Integer> result){
        result.add(curr);
        for(int child : map.getOrDefault(curr, new ArrayList<>())){
            if(child != par){
                dfs(curr, map, child, result);
            }
        }
    }

}