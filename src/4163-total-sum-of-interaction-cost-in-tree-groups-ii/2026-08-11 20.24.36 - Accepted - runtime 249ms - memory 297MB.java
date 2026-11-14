class Solution {
    List<Integer> adjList[];
    int n;
    int group[];
    int depth[];
    int parent[][];
    int tin[];
    int tout[];
    int log = 18; 
    int timer = 0;
    public long interactionCosts(int n, int[][] edges, int[] group) {
        this.n = n;
        this.group = group;
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        parent = new int[n][log];
        adjList= new ArrayList[n];

        for(int i=0;i<n;i++) adjList[i] = new ArrayList<>();

        for(var e : edges){
            var u =e[0];
            var v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }
        dfs(0, 1, 0);
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.computeIfAbsent(group[i], x ->new ArrayList<>()).add(i);
        }

        long res = 0;

        for(var entry : map.entrySet()){
            var key = entry.getKey();
            var list = entry.getValue();

            if(list.size() == 1) continue;

            Collections.sort(list, (a, b) -> tin[a] - tin[b]);
            List<Integer> lca = new ArrayList<>(list);
            for(int i=1;i<list.size();i++){
                lca.add(lca(list.get(i-1), list.get(i)));
            }

            Collections.sort(lca, (a,b) -> tin[a] - tin[b]);

            List<Integer> distinct = new ArrayList<>();
            int prev = -1;
            for(int x : lca){
                if(prev != x){
                    prev = x;
                    distinct.add(x);
                }
            }

            int m = distinct.size();

            int parent[] = new int[m];
            Arrays.fill(parent, -1);

            var stack =new Stack<Integer>();
            for(int i=0;i<m;i++){
                while(!stack.isEmpty() && !ancestor(distinct.get(stack.peek()), distinct.get(i))){
                    stack.pop();
                }

                if(!stack.isEmpty()){
                    parent[i] = stack.peek();
                }
                stack.push(i);
            }

            int cnt[] = new int[m];

            for(int i=0;i<m;i++){
                if(group[distinct.get(i)] == key){
                    cnt[i] = 1;
                }
            }

            for(int i = m-1;i>=0;i--){
                int p = parent[i];
                if( p != -1){
                    long c = cnt[i];

                    res += c * (list.size() - c)*  (depth[distinct.get(i)] - depth[distinct.get(p)])  ;
                    cnt[p] += cnt[i];

                }
            }

        }


        return res;
    }

    private boolean ancestor(int u, int v){
        return tin[u] <= tin[v] && tout[v] <= tout[u];
    }

    private void dfs(int curr, int d, int par){
        depth[curr] = d;
        parent[curr][0] = par;
        tin[curr] = timer++;
        for(int i=1;i<log;i++){
            int pp = parent[curr][i - 1];
            parent[curr][i] = parent[pp][i-1];
        }

        for(var child : adjList[curr]){
            if(child == par){
                continue;
            }

            dfs(child, d + 1, curr);
        }

        tout[curr] = timer++;
    }

    private int lca(int u, int v){
        if(depth[u] < depth[v]){
            return lca(v, u);
        }
        int diff = depth[u] - depth[v];
        for(int i= log - 1;i >=0;i--){
            int bit = (1 <<i ) & diff;
            if(bit !=0){
                u = parent[u][i];
            }
        }

        if(u ==v) return u;

        for(int i = log - 1;i >=0 ;i--){
            if(parent[u][i] != parent[v][i]){
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        return parent[u][0];
    }


}