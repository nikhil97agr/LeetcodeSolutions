class Solution {
    public int minKnightMoves(int x, int y) {
        int ans = 0;
        Queue<int[]> que = new LinkedList<>();
        Map<Integer, Set<Integer>> vis = new HashMap<>();
        add(vis, 0, 0);
        que.offer(new int[]{0, 0});
        int dir[][] = new int[][]{
            {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
            {-2, -1}, {-1,-2}, {1, -2}, {2, -1}
        };
        while(!que.isEmpty()){
            int size = que.size();
            while(size -- > 0){
                int next[] = que.poll();

                if(next[0] == x && next[1] == y){
                    return ans;
                }

                for(int d [] : dir){
                    int nr = next[0] + d[0];
                    int nc = next[1] + d[1];

                    if(nr < -500 || nr > 500 || nc < -500 || nc > 500 ||vis(vis, nr, nc)){
                        continue;
                    }

                    add(vis, nr, nc);
                    que.offer(new int[]{nr, nc});
                }

            }

            ans++;
        }
        return -1;
    }

    private void add(Map<Integer, Set<Integer>> map, int x, int y){
        map.computeIfAbsent(x, x1 -> new HashSet<>()).add(y);
    }

    private boolean vis(Map<Integer, Set<Integer>> map, int x, int y){
        if(!map.containsKey(x)) return false;

        return map.get(x).contains(y);
    }
}