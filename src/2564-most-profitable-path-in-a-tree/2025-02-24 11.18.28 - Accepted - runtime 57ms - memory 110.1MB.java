class Solution {

    
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }
        for(int edge[]: edges){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        Map<Integer, Integer> bobPath = new HashMap<>();

        bobTraversal(bob, -1, 0, bobPath, adjList);

        int ans = Integer.MIN_VALUE;
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{0, -1, 0, 0});

        while(!que.isEmpty()){
            int path[] = que.poll();
            int amt = path[2] + getAmount(amount, path[0], path[3], bobPath); 
            int node = path[0];
            if(adjList[node].size()==1 && node!=0){
                ans = Math.max(ans, amt);
                continue;
            }

            Iterator<Integer> it = adjList[node].iterator();
            while(it.hasNext()){
                int x = it.next();
                if(x != path[1]){
                    que.add(new int[]{x, node, amt, path[3]+1});
                }
            }
        }
        return ans;
    }

    private int getAmount(int amount[], int node, int steps, Map<Integer, Integer> bobPath){
        if(!bobPath.containsKey(node)) return amount[node];
        int cnt  = bobPath.get(node);

        if(steps == cnt) return amount[node]/2;
        if(steps>cnt) return 0;

        return  amount[node];
    }

    public boolean bobTraversal(int bob, int parent, int steps, Map<Integer, Integer> bobPath, LinkedList<Integer> graph[]){
        if(bob==0) return true;

        bobPath.put(bob, steps);

        Iterator<Integer> it = graph[bob].iterator();
        while(it.hasNext()){
            int child = it.next();
            if(child == parent) continue;

            if(bobTraversal(child, bob, steps+1, bobPath, graph)) return true;
        }

        bobPath.remove(bob);

        return false;

    }
}