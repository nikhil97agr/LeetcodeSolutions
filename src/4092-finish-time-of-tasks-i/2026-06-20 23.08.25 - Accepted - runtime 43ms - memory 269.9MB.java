class Solution {
    List<Integer> adjList[];
    int n;
    int baseTime[];
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        
        this.n = n;
        this.baseTime = baseTime;
        adjList= new ArrayList[n];
        for(int i=0;i<n;i++) adjList[i] = new ArrayList<>();
        for(var e : edges){
            var u =e[0];
            var v = e[1];
            adjList[u].add(v);
        }

        var res =  solve(0);

        return res;
    }

    private long solve(int curr){
        if(adjList[curr].size() == 0){
            return baseTime[curr];
        }
        long earliest =Long.MAX_VALUE;
        long latest = Long.MIN_VALUE;

        for(var child : adjList[curr]){
            var val = solve(child);
            earliest = Math.min(earliest, val);
            latest = Math.max(latest, val);
        }

        var own = (latest - earliest) + baseTime[curr];
        var t = latest + own;

        return t;
    }
}