import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        long mod = (long)1e9+7;
        long cnt[] = new long[n];
        long time[] = new long[n];
        Arrays.fill(cnt, 0);
        cnt[0] =1;
        Arrays.fill(time, (long)1e14);
        time[0] = 0;
        PriorityQueue<Path> que = new PriorityQueue<>(Comparator.comparingLong(p -> p.time));
        que.offer(new Path(0, 0));
        LinkedList<Path> adjList[] = build(roads,n);

        while(!que.isEmpty()){
            Path path = que.poll();
            int currNode= path.dest;
            long currTime = path.time;

            if(time[currNode] < currTime) continue;

            for(Path child : adjList[currNode]){
                int childNode = child.dest;
                long childTime = child.time;

                if(childTime + currTime < time[childNode]){
                    time[childNode] = currTime + childTime;
                    cnt[childNode] = cnt[currNode];
                    que.offer(new Path(childNode, currTime + childTime));
                }else if(childTime + currTime == time[childNode]){
                    cnt[childNode] = addMod(cnt[childNode], cnt[currNode], mod);
                }
            }
        }
        
        
        return (int)cnt[n-1];
    }
    
    private LinkedList<Path>[]  build(int roads[][], int n){
        LinkedList<Path> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        
        for(int r[] : roads){
            int u = r[0];
            int v = r[1];
            int t = r[2];
            
            adjList[u].add(new Path(v, t));
            adjList[v].add(new Path(u, t));
        }
        
        return adjList;
    }

    class Path{
        int dest;
        long time;
        public Path(int dest, long time){
            this.dest = dest;
            this.time = time;
        }
    }


    private long addMod(long a, long b, long mod){
        return (a%mod + b%mod) % mod;
    }
}