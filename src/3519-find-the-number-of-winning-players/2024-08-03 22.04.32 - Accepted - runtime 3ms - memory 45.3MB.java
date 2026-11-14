class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        Map<Integer, Integer> map[] = new HashMap[n];
        for(int i=0;i<n;i++) map[i] = new HashMap<>();

        for(int p[] : pick){
            int cnt = map[p[0]].getOrDefault(p[1], 0);
            map[p[0]].put(p[1], cnt+1);

        }

        int ans = 0;

        for(int i=0;i<n;i++){
            int max = -1;

            for(int x : map[i].values()){
                max = Math.max(x, max);
            }
            if(max > i) ans++;
        }
        return ans;
    }
}