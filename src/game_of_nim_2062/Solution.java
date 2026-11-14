package game_of_nim_2062;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {

    public boolean nimGame(int[] piles) {

        Map<State, Boolean> map = new HashMap<>();
        return check(piles, piles.length, 0, map);
    }

    private boolean check(int piles[], int n, int turn, Map<State, Boolean> map) {
        String key = key(piles);
        State state = new State(key, turn);
        
        if(map.containsKey(state)){
             return map.get(state);
        }
        for (int j = 0; j < n; j++) {
            if (piles[j] != 0) {
                for (int c = 1; c <= piles[j]; c++) {
                    piles[j] -= c;
                    int next[] = piles.clone();
                    boolean res = check(next, n, turn ^ 1, map);
                    piles[j] += c;

                    if ((!res && turn == 1) || (res && turn == 0)) {
                        map.put(state, res);
                        return res;
                    }
                }
            }
        }

        boolean res = turn != 0;
        map.put(state, res);
        return res;

    }

    public String key(int[] arr) {

        StringBuilder key = new StringBuilder();

        for (int x : arr) {
            key.append(x).append("-");
        }

        return key.toString();

    }

    class State {

        String key;
        int turn;

        public State(String key, int turn) {

            this.key = key;
            this.turn = turn;
        }

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return turn == state.turn && Objects.equals(key, state.key);
        }

        @Override
        public int hashCode() {

            return Objects.hash(key, turn);
        }
    }
}