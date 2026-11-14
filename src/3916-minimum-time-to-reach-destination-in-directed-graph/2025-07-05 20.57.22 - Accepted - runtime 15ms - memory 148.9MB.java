import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
    public int minTime(int n, int[][] edges) {
        LinkedList<Edge> adjList[] = build(edges, n);
        long min[] = new long[n];
        Arrays.fill(min, Long.MAX_VALUE);
        min[0] = 0;
        PriorityQueue<Cell> que=  new PriorityQueue<>((a,b) -> Long.compare(a.time, b.time));

        que.offer(new Cell(0, 0));

        while(!que.isEmpty()){
            Cell cell = que.poll();
            int u = cell.u;
            long time = cell.time;

            if(u==n-1){
                return (int)time;
            }

            for(Edge edge: adjList[u]){
                int v = edge.v;
                if(1l*edge.start <= time && time <= 1l*edge.end){
                    if(time +1 <min[v]){
                        min[v] = time+1;
                        que.offer(new Cell(v, time+1));

                    }
                    continue;
                }

                if(time > 1l*edge.end) continue;

                long next = 1l*edge.start - time + 1;

                if(time + next < min[v]){
                    min[v] = time + next;
                    que.offer(new Cell(v, time + next));
                }
            }


        }

        return -1;

    }

    class Cell{
        int u;
        long time;

        public Cell(int u, long time){
            this.u = u;
            this.time = time;
        }
    }

    private LinkedList<Edge> []build(int edges[][], int n){
        LinkedList<Edge> adjlist[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjlist[i] = new LinkedList<>();

        for(int e[] : edges){
            adjlist[e[0]].add(new Edge(e[1], e[2], e[3]));
        }

        return adjlist;
    }


    class Edge{
        int v;
        int start;
         int end;

         public Edge(int v, int start, int end){
             this.v = v;
             this.start = start;
             this.end = end;
         }
    }
}