import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int time = 0;
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Integer> adjList[] = new ArrayList[n];
        for(int i=0;i<n;i++) adjList[i] = new ArrayList<>();
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        int depth[] = new int[n];
        int parent[][] = new int[n][17];
        int in[] = new int[n];
        int out[] = new int[n];
        int bit[] = new int[n+4];
        char ch[] = s.toCharArray();
        List<Boolean> result = new ArrayList<>();
        dfs(0, 0, 0, in, parent, depth, ch, out, n, adjList);

        for(int i=0;i<n;i++){
            int mask = (1 << ch[i] - 'a');
            update(in[i], out[i], mask, n, bit);
        }

        for(String q : queries){
            String st[] = q.split(" ");
            if(st[0].equals("query")){
                int u = Integer.parseInt(st[1]);
                int v = Integer.parseInt(st[2]);
                int lca= getLca(u, v, depth, parent);
                int mask = query(in[u], bit) ^ query(in[v], bit) ^ (1 << (ch[lca] - 'a'));
                result.add(mask ==0 || (mask & (mask-1)) ==0 );
            }else{
                int ind = Integer.parseInt(st[1]);
                char c = st[2].charAt(0);
                int old = (1 << (ch[ind] - 'a'));
                int newMask = (1 << (c-'a'));
                ch[ind] = c;
                int diff = old ^ newMask;
                update(in[ind], out[ind], diff, n, bit);
            }
        }
        return result;
    }
    
    private int query(int ind, int bit[]){
        int ans = 0;
        for(;ind > 0 ; ind -= (ind & -ind)) ans ^= bit[ind];
        
        return ans;
    }

    private int getLca(int u, int v, int depth[], int parent[][]){
        if(depth[u] < depth[v]) return getLca(v, u, depth, parent);
        for(int i=16;i>=0;i--){
            if(depth[u] - (1 << i) >= depth[v]) u = parent[u][i];
        }

        if(u==v) return u;

        for(int i=16;i>=0;i--){
            if(parent[u][i] != parent[v][i]){
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        return parent[u][0];
    }

    private void update(int l, int r, int val, int n, int bit[]){
        update(l, val, n, bit);
        update(r +1 , val, n, bit);
    }

    private void update(int ind ,int val, int n, int bit[]){
        for(;ind <= n;ind+=(ind & -ind)) bit[ind] ^= val;
    }



    private void dfs(int u, int p, int d, int in[], int parent[][], int depth[], char ch[], int out[], int n, List<Integer> adjList[]){
        in[u] = ++time;
        parent[u][0] = p;
        depth[u] = d;


        for(int i=1;i<17;i++){
            parent[u][i] = parent[parent[u][i-1]][i-1];
        }
        for(int child : adjList[u]){
            if(child != p){
                dfs(child, u, d +1, in, parent, depth, ch, out, n, adjList);
            }


        }

        out[u] = time;
    }
}