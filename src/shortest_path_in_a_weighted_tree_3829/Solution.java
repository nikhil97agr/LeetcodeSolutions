package shortest_path_in_a_weighted_tree_3829;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Integer, Map<Integer, Integer>> map;
    List<Integer> flatTree;
    int tin[];
    int tout[];
    public int[] treeQueries(int n, int[][] edges, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        flatTree = new ArrayList<>();
        tin = new int[n+1];
        tout = new int[n+1];
        map = new HashMap<>();
        for (var e : edges) {
            var u = e[0];
            var v = e[1];
            var w = e[2];

            map.computeIfAbsent(u, x -> new HashMap<>()).put(v, w);
            map.computeIfAbsent(v, x -> new HashMap<>()).put(u, w);
        }

        dfs(1 , 0, -1);

        var tree = new SegmentTree(flatTree);

        for(var q : queries){
            if(q[0] == 1){

                int u = q[1];
                int v = q[2];
                int w = q[3];
                v= Math.max(u,v);
                var in = tin[v];
                var out = tout[v];
                tree.update(1, in, w, 0, flatTree.size()-1);
                tree.update(1, out, -w, 0, flatTree.size()- 1);

            }else{
                var node = q[1];
                result.add(tree.query(1, 0, flatTree.size() - 1, tin[1], tin[node]));
            }
        }
        var ans = new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i] = result.get(i);
        }

        return ans;

    }

    private void dfs(int curr, int w, int par){
        flatTree.add(w);
        tin[curr] = flatTree.size() - 1;
        for(var entry : map.getOrDefault(curr, new HashMap<>()).entrySet()){
            int v = entry.getKey();
            int d = entry.getValue();
            if(v != par){
                dfs(v, d, curr);
            }
        }

        flatTree.add(-w);
        tout[curr] = flatTree.size() - 1;

    }

    class SegmentTree{

        int tree[];
        public SegmentTree(List<Integer> list){
            tree = new int[4 * list.size()];
            for(int i=0;i<list.size();i++){
                update(1, i, list.get(i), 0, list.size() - 1);
            }
        }

        public void update(int ind, int i, int val, int l, int r){
            if( i < l || r < i){
                return;
            }

            if(l == r){
                tree[ind] = val;
                return;
            }

            int mid = (l + r)/2;

            update(2 * ind, i, val, l , mid);
            update(2 * ind + 1, i, val,mid+ 1, r);

            tree[ind] = tree[ind*2] + tree[2*ind + 1];
        }
        
        public int query(int ind, int l, int r, int ql, int qr){
            if(qr < l || ql > r){
                return 0;
            }
            
            if(ql <= l && r <= qr){
                return tree[ind];
            }
            
            int mid = (l + r)/2;
            
            return query(2 * ind , l ,mid, ql ,qr) + query(2 * ind + 1, mid + 1, r, ql, qr);
        }
    }
}