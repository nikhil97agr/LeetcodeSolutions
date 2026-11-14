package grid_teleportation_traversal_3837;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int minMoves(String[] matrix) {
        Map<Character, List<int[]>> map = new HashMap<>();
        int n= matrix.length;
        int m = matrix[0].length();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch = matrix[i].charAt(j);
                map.computeIfAbsent(ch, x-> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        int minMoves[][] = new int[n][m];
        for(int mm[] : minMoves){
            Arrays.fill(mm, Integer.MAX_VALUE);
        }

        minMoves[0][0] = 0;

        PriorityQueue<State> que = new PriorityQueue<>((s1, s2) -> s1.moves - s2.moves);
        char c[] =new char[26];
        Arrays.fill(c, '0');
        que.offer(new State(0, 0, 0, c));
        int dir[] = new int[]{0,1,0, -1, 0};
        while(!que.isEmpty()){
            State state = que.poll();
            
            if(state.i == n-1 && state.j == m-1){
                return state.moves;
            }
            
            for(int i=0;i<4;i++){
                int ni = state.i + dir[i];
                int nj = state.j + dir[i+1];
                
                if(ni < 0 || nj < 0 || ni >= n || nj >= m || matrix[ni].charAt(nj) == '#' || minMoves[ni][nj] <= state.moves+1){
                    continue;
                }
                
                minMoves[ni][nj] = state.moves + 1;
                que.offer(new State(ni, nj, state.moves + 1, state.ch));
                
                
            }
            
            int i = state.i;
            int j = state.j;
            
            char ch = matrix[i].charAt(j);
            
            if(ch == '.') continue;
            
            if(state.ch[ch-'A'] == '0'){
                List<int[]> list = map.get(ch);
                char temp[] = state.ch;
                temp[ch-'A'] = 'A';
                for(int []x : list){
                    if(x[0] == i && x[1] == j) continue;
                    int ni = x[0];
                    int nj=  x[1];
                    if(minMoves[ni][nj] > state.moves){
                        minMoves[ni][nj]= state.moves;
                        que.offer(new State(ni, nj, state.moves, temp.clone()));
                    }
                }
            }
            
        }
        return -1;
    }

    class State{
        int i;
        int j;
        int moves;
        char ch[];

        public State(int i, int j, int moves, char ch[]){
            this.i = i;
            this.j = j;
            this.moves = moves;
            this.ch = ch;
            
        }
    }
}