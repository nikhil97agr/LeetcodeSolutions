class Solution {
    int ans = 0;
    public int countGoodNodes(int[][] edges) {
        int n = edges.length+1;
        LinkedList<Integer> adjList[] = new LinkedList[n];
        
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        
        for(int e[] : edges){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        
        solve(adjList, 0, -1);
        
        return ans;
    }
    
    private int solve(LinkedList<Integer> adjList[], int u, int par){
        
        Map<Integer, Integer> map= new HashMap<>();
        
        for(int child : adjList[u]){
            if(child != par){
                int cnt = solve(adjList, child, u);
                map.put(cnt, map.getOrDefault(cnt,0 )+1);
            }
        }
        
        if(map.isEmpty()){
            ans++;
            return 1;
        }
        
        if(map.size() == 1){
            ans++;
        }
        
        int total = 0;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            total += entry.getKey() * entry.getValue();
        }
        return total+1;
        
        
        
    }
}