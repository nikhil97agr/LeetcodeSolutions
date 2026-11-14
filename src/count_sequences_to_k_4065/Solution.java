package count_sequences_to_k_4065;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    Map<State, Integer> dp = new HashMap<>();
    
    public int countSequences(int[] nums, long k) {
        return solve(0, nums, nums.length, 1, 1, k);
    }

    private int solve(int i, int nums[], int n, long num, long den, long k){
        if(i ==n){
            if( den == 1l && num == k) return 1;
            return 0;
        }
        State state = new State(i, num, den);
        if(dp.containsKey(state)) return dp.get(state);
        long g1 = gcd(num * nums[i], den);
        int ans= solve(i+1, nums, n, num, den, k) + solve(i+1, nums, n, (num * nums[i])/g1, den/g1, k);

        long gcd = gcd(num, den * nums[i]);
        ans = ans  + solve(i+1, nums, n, num/gcd, (den * nums[i])/gcd, k);
        dp.put(state, ans);
        return ans;
    }

    private long gcd(long a, long b){
        if(b==0) return a;

        return gcd(b, a%b);
    }
    
    class State{
        int i;
        long num;
        long den;

        public State(int i, long num, long den) {

            this.i = i;
            this.num = num;
            this.den = den;
        }

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return i == state.i && num == state.num && den == state.den;
        }

        @Override
        public int hashCode() {

            return Objects.hash(i, num, den);
        }
    }
}