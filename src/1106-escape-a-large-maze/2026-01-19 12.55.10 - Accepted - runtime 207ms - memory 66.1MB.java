class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        HashMap<Integer, Set<Integer>> map =new HashMap<>();
        for(int b[] : blocked){
            map.computeIfAbsent(b[0], x-> new HashSet<>()).add(b[1]);
        }

        return !dfs(source, map, target) && !dfs(target, map, source);
    }

    private boolean dfs(int source[], Map<Integer, Set<Integer>> map, int target[]){
        Queue<int[]> que = new LinkedList<>();
        Map<Integer, Set<Integer>> vis= new HashMap<>();
        que.offer(new int[]{source[0], source[1]});
        int ans = 0;
        vis.computeIfAbsent(source[0], x-> new HashSet<>()).add(source[1]);
        while(!que.isEmpty()){
            if(ans >= 20000) return false;
            int size = que.size();
            while(size-- > 0){
                int next[] = que.poll();
                ans++;
                if(next[0]== target[0] && next[1] == target[1]) return false;
                int dir[] = new int[]{0, 1, 0, -1, 0};
                for(int i=0;i<4;i++){
                    int ni = next[0] + dir[i];
                    int nj= next[1] + dir[i+1];
                    if(ni >=0 && nj >= 0 && ni <1000000 && nj < 1000000 && !vis(ni,nj, vis) && !vis(ni, nj, map)){
                        que.offer(new int[]{ni, nj});
                        vis.computeIfAbsent(ni, y -> new HashSet<>()).add(nj);
                    }
                }
            }
        }

        return true;
    
    }

    private boolean vis(int x, int y, Map<Integer, Set<Integer>> map){
        if(!map.containsKey(x)) return false;

        return map.get(x).contains(y);
    }
}