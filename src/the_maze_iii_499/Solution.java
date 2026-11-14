package the_maze_iii_499;

import java.util.*;
class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int n = maze.length;
        int m = maze[0].length;

        PriorityQueue<State> que = new PriorityQueue<>((a,b)->{
            if(a.dist == b.dist) return a.dir.compareTo(b.dir);

            return a.dist - b.dist;
        });

        char dir[] = new char[]{'l', 'u', 'r', 'd'};
        int diff[][] = new int[][]{{0, -1},{-1, 0}, {0,1}, {1,0}};

        que.offer(new State(ball[0], ball[1], 0, ""));
        boolean visited[][] = new boolean[n][m];
        while(!que.isEmpty()){
            State curr = que.poll();
            if(visited[curr.r][curr.c]) continue;
            if(curr.r == hole[0] && curr.c==hole[1]) return curr.dir;
            visited[curr.r][curr.c] = true;
            for(State next : getNextStates(curr, hole, dir, diff, n, m, maze)){
                que.add(next);
            }
        }

        return "impossible";
    }

    private List<State> getNextStates(State curr, int hole[], char dir[], int diff[][], int n, int m, int maze[][]){
        List<State> neighbors =new ArrayList<>();   
        for(int i=0;i<4;i++){
            int dx  = diff[i][0];
            int dy = diff[i][1];
            char d = dir[i];

            int r = curr.r + dx;
            int c = curr.c + dy;
            int count = 0;
            while(r <n && r>=0 && c <m && c>=0 && maze[r][c]==0){

                r+=dx;
                c+= dy;
                if(r-dx==hole[0] && c-dy==hole[1]) break;
                count++;
            }

            neighbors.add(new State(r-dx, c-dy,curr.dist + count, curr.dir +d ));



        }
        return neighbors;
    }
}

class State{
    int r;
    int c;
    int dist;
    String dir;

    public State(int r, int c, int dist, String dir){
        this.r =r;
        this.c = c;
        this.dist =dist;
        this.dir = dir;
    }
}