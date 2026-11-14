package design_snake_game_353;

import java.util.*;
class SnakeGame {
    boolean vis[][];
    int n;
    int m;
    int food[][];
    Deque<int[]> que;
    int index = 0;
    public SnakeGame(int width, int height, int[][] food) {
        vis = new boolean[height][width];
        n = height;
        m = width;
        this.food = food;
        que = new LinkedList<>();
        que.offer(new int[]{0,0});
        vis[0][0] = true;
    }
    
    public int move(String direction) {
        int pos[] = que.peekLast();
        int r= pos[0];
        int c = pos[1];
        switch(direction){
            case "U":
            r--;
            break;
            case "D":
            r++;
            break;
            case "L":
            c--;
            break;
            case "R":
            c++;
            break;
        }
        if(r < 0 || c < 0 || r >= n || c >= m || (vis[r][c] && (r != que.peekFirst()[0] ||c != que.peekFirst()[1]))){
            return -1;
        }
        if(index < food.length){
            if(r == food[index][0] && c == food[index][1]){
                index++;

            }else{
               int prev[] =  que.pollFirst();
               vis[prev[0]][prev[1]] = false;
            }
        }else{
            int prev[] = que.pollFirst();
            vis[prev[0]][prev[1]] = false;
        }
        vis[r][c] = true;
        que.offerLast(new int[]{r,c});
        return que.size()-1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */