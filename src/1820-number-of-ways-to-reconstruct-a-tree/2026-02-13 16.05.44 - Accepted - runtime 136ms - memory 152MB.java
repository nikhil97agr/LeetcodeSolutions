class Solution {
    public int checkWays(int[][] pairs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int p[] : pairs){
            int u = p[0];
            int v = p[1];
            set.add(u);
            set.add(v);
            map.computeIfAbsent(u, x ->new HashSet<>()).add(v);
            map.computeIfAbsent(v, x-> new HashSet<>()).add(u);
        }
        int n = set.size();
        int root = -1;
        for(int node : map.keySet()){
            int size = map.get(node).size();
            if(size == n-1){
                root = node;
                break;
            }
        }

        if(root == -1) return 0;
        int ans = 1;
        for(int node : map.keySet()){
            if(node == root) continue;

            int parent = -1;
            int maxDegree = Integer.MAX_VALUE;

            for(int p : map.get(node)){
                if(map.get(p).size() >= map.get(node).size() && map.get(p).size() < maxDegree){
                    parent= p;
                    maxDegree = map.get(p).size();
                }
            }

            if(parent == -1) return 0;

            for(int m : map.get(node)){
                if(m == parent)continue;
                if(!map.get(parent).contains(m)) return 0;
            }

            if(map.get(parent).size() == map.get(node).size()) ans = 2;
        }



        return ans;

    }
}