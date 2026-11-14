class Solution {
    public double minTime(int n, int k, int m, int[] time, double[] mul) {
        if(k==1){
            if( n > 1 ) return -1;
            return mul[0] * time[0];
        }

        int max = 1 << n;
        boolean vis[][][] = new boolean[max][m][2];
        List<int[]> groups = new ArrayList<>();
        for(int i=1;i<max;i++){
            int cnt = Integer.bitCount(i);
            if(cnt <= k){
                groups.add(new int[]{i, maxTime(time, i)});
            }
        }

        PriorityQueue<State> que = new PriorityQueue<>((a,b)-> Double.compare(a.cost, b.cost));

        que.offer(new State(0, 0, 0, 0));

        while(!que.isEmpty()){
            State state = que.poll();

            if(state.mask == max-1) return state.cost;

            if(vis[state.mask][state.m][state.flag]) continue;
            vis[state.mask][state.m][state.flag] = true;

            if(state.flag == 0){
                for(int[] g : groups){
                    int mask = g[0];
                    int t= g[1];
                    if((mask & state.mask) !=0) continue;
                    double newTime = t * mul[state.m];
                    int nextState = (state.m + (int)Math.floor(newTime))%m;
                    int newMask = state.mask | mask;
                    if(!vis[newMask][nextState][1]){
                        que.offer(new State(newMask, nextState, 1, state.cost + newTime));
                    }
                }
            }else{
                for(int j=0;j<n;j++){
                    if((state.mask & (1<<j))!=0){
                        double travelTime = time[j] * mul[state.m];
                        int next = (state.m + (int)Math.floor(travelTime))%m;
                        int mask = state.mask ^ (1<<j);
                        if(!vis[mask][next][0]){
                            que.offer(new State(mask, next, 0, state.cost + travelTime));
                        }
                    }
                }
            }
        }

        return -1;

    }

    private int maxTime(int time[], int state){
        int max = 0;
        for(int j=0;j<time.length;j++){
            if( ( state & (1<<j))!=0){
                max = Math.max(max, time[j]);
            }
        }

        return max;
    }

    class State{
        int mask;
        int m;
        int flag;
        double cost;
        public State(int mask, int m, int flag, double cost){
            this.mask = mask;
            this.m = m;
            this.flag= flag;
            this.cost = cost;
        }
    }
}