class Solution {
    enum Color{
        BLACK,GRAY;
    }
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i, new HashSet<>());
        }
        for(int e[] : edges){
            graph.get(e[0]).add(e[1]);
        }

        return dfs(source, destination, graph, new Color[n]);
    }

    private boolean dfs(int src, int dest, Map<Integer, Set<Integer>> map, Color color[]){
        if(color[src]!=null){
            return color[src] == Color.BLACK;
        }

        if(map.get(src).size()==0){
            return src == dest;
        }
        color[src] = Color.GRAY;
        for(int x : map.get(src)){
            if(!dfs(x, dest, map, color)) return false;
        }

        color[src] = Color.BLACK;

        return true;
    }
}