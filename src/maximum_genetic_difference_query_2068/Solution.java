package maximum_genetic_difference_query_2068;

import java.util.*;

class Solution {
    Map<Integer, List<int[]>> map;
    int ans[];
    int n;
    List<Integer> adjList[];
    Trie trie;
    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int n= parents.length;
        ans = new int[queries.length];
        adjList = new ArrayList[n];
        int root = -1;
        map = new HashMap<>();
        for(int i=0;i<n;i++) adjList[i] =new ArrayList<>();
        for(int i=0;i<n;i++){
            if(parents[i] != -1){
                adjList[parents[i]].add(i);
            }else{
                root= i;
            }
        }
        for(int i=0;i<ans.length;i++){
            int node = queries[i][0];
            int val =queries[i][1];
            map.computeIfAbsent(node, x -> new ArrayList<>()).add(new int[]{val, i});
        }
        trie = new Trie();
        dfs(root, -1);

        return ans;

    }

    private void dfs(int curr, int par){
        trie.add(curr, 18);

        if(map.containsKey(curr)){
            for(int query[] : map.get(curr)){
                int val = query[0];
                int ind = query[1];
                int res = trie.search(val, 0, 18);
                ans[ind] = res;
            }
        }

        for(int child : adjList[curr]){
            if(child == par) continue;
            dfs(child, curr);
        }

        trie.remove(curr, 18);
    }

    class Trie{
        Trie trie[];
        int cnt;
        public Trie(){
            trie = new Trie[2];
            cnt = 0;
        }

        public int search(int val, int curr, int bitIndex){
            if(bitIndex == -1){
                return curr;
            }

            int bit = (val >> bitIndex) & 1;
            int toggle = bit ^ 1;

            if(trie[toggle] != null){
                return trie[toggle].search(val, curr | (1 << bitIndex), bitIndex - 1);
            }

            return trie[bit].search(val, curr, bitIndex - 1);
        }

        public void add(int val, int bitIndex){
            cnt++;
            if(bitIndex == -1){
                return;
            }


            int bit = (val >> bitIndex ) & 1;
            if(trie[bit] == null){
                trie[bit] = new Trie();
            }

            trie[bit].add(val, bitIndex - 1);
        }

        public void remove(int val, int bitIndex){
            cnt--;
            if(bitIndex == -1){
                return;
            }

            int bit = (val >> bitIndex) & 1;
            trie[bit].remove(val, bitIndex-1);
            if(trie[bit].cnt == 0){
                trie[bit] = null;
            }
        }
    }


}