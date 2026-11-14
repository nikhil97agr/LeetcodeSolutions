package find_the_kth_smallest_sum_of_a_matrix_with_sorted_rows_1550;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> q1 = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<State> pq = new PriorityQueue<State>((a,b) -> a.sum - b.sum);
        int n = mat.length;
        int m = mat[0].length;
        int sum =0;
        List<Integer> indexes = new ArrayList<>();
        for(int i=0;i<n;i++){
            sum += mat[i][0];
            indexes.add(0);

        }
        
        Set<State> visited = new HashSet<>();

        State state = new State(sum, indexes);
        pq.offer(state);
        visited.add(state);
        while(q1.size() < k){
            state = pq.poll();
            q1.offer(state.sum);

            List<Integer> list = state.indexes;
            sum = state.sum;
            for(int i=0;i<n;i++){
                int ind = list.get(i);
                if(ind + 1 < m){
                    List<Integer> clone = new ArrayList<>(list);
                    clone.set(i, ind + 1);
                    state = new State(sum - mat[i][ind] + mat[i][ind+1], clone);
                    if(visited.contains(state)) continue;
                    pq.offer(state);
                    visited.add(state);
                }
            }
        }

        return q1.poll();
    }

    class State{
        int sum;
        List<Integer> indexes;
        public State(int sum, List<Integer> indexes){
            this.sum = sum;
            this.indexes =indexes;
        }

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return sum == state.sum && Objects.equals(indexes, state.indexes);
        }

        @Override
        public int hashCode() {

            return Objects.hash(sum, indexes);
        }
    }
}