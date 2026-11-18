package cat_and_mouse_949;

import java.util.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int mouse = 0;
    int cat = 1;
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        Result dp[][][] = new Result[n][n][2];
        for(Result a[][] : dp){
            for(Result b[] : a){
                Arrays.fill(b, Result.DRAW);
            }
        }

        int degree[][][] = new int[n][n][2];
        for(int c =1;c<n;c++){
            for(int m=0;m<n;m++){
                degree[m][c][mouse] = graph[m].length;
                degree[m][c][cat] = graph[c].length;

            }
        }
        for(int c : graph[0]){
            for(int m=0;m<n;m++){
                degree[m][c][1]--;
            }
        }
        Queue<State> que =new LinkedList<>();
        for(int c=1;c<n;c++){
                for(int turn =0;turn <=1; turn++){
                    dp[0][c][turn] = Result.MOUSE;
                    dp[c][c][turn] = Result.CAT;

                    que.offer(new State(0, c, Result.MOUSE, turn));
                    que.offer(new State(c, c, Result.CAT, turn));
                }
            
        }

        while(!que.isEmpty()){
            State state = que.poll();
            if(state.turn == mouse && state.mouse == 1 && state.cat == 2){
                return state.result.val;
            }
            if(state.turn == cat){
                for(int pos: graph[state.mouse]){
                    if(!dp[pos][state.cat][mouse].equals(Result.DRAW)){
                        continue;
                    }

                    if(state.result.equals(Result.MOUSE) || --degree[pos][state.cat][mouse] ==0){
                        dp[pos][state.cat][mouse] = state.result;
                        que.offer(new State(pos, state.cat, state.result, mouse));
                    }
                }
            }else{
                
                for(int pos: graph[state.cat]){
                    if(!dp[state.mouse][pos][cat].equals(Result.DRAW)){
                        continue;
                    }

                    if(state.result.equals( Result.CAT) || --degree[state.mouse][pos][cat] == 0){
                        dp[state.mouse][pos][cat] = state.result;
                        que.offer(new State(state.mouse, pos, state.result, cat));
                    }
                }
            }
        }


        return dp[1][2][mouse].val;
    }

    class State{
        int mouse;
        int cat;
        Result result;
        int  turn;

        public State(int mouse, int cat, Result result, int turn) {
            this.mouse = mouse;
            this.cat = cat;
            this.result = result;
            this.turn = turn;
        }
    }
    enum Result{
        MOUSE(1),
        CAT(2),
        DRAW(0);
        int val;
        private Result(int val){
            this.val = val;
        }
    }


}