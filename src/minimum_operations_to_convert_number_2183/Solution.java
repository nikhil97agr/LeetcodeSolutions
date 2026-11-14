package minimum_operations_to_convert_number_2183;

import java.util.*;
class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        PriorityQueue<State> que = new PriorityQueue<>((s1, s2) -> s1.cnt - s2.cnt);
        int n = nums.length;
        boolean vis[][] = new boolean[n][1001];

        que.offer(new State(start, 0));
        
        while(!que.isEmpty()){
            State state = que.poll();

            if(state.num == goal) return state.cnt;

            if(state.num < 0 || state.num > 1000) continue;


            for(int i=0;i<n;i++){
                if(!vis[i][state.num]){
                    vis[i][state.num] = true;
                    que.offer(new State(state.num + nums[i], state.cnt + 1));
                    que.offer(new State(state.num - nums[i], state.cnt + 1));
                    que.offer(new State(state.num ^ nums[i], state.cnt + 1));
                }
            }
        }

        return -1;
    }

    class State{
        int num;
        int cnt;

        public State(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
}