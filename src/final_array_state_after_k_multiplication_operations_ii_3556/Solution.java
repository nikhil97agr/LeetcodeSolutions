package final_array_state_after_k_multiplication_operations_ii_3556;

import java.util.*;
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        int ans[] = new int[n];
        if(multiplier == 1) return nums;
        PriorityQueue<State> que =new PriorityQueue<>((a,b)->{
            if(a.val == b.val) return a.ind - b.ind;
            return Long.compare(a.val, b.val);
        });

        for(int i=0;i<n;i++){
            que.offer(new State(i, nums[i]));
        }
        long max = Arrays.stream(nums).max().getAsInt();
        while(!que.isEmpty() && k > 0){
            State next = que.peek();

            if(next.val >= max){
                break;
            }

            k--;
            que.poll();
            next.val *= multiplier;
            que.offer(next);

        }
        if(k==0){
            while(!que.isEmpty()){
                State state = que.poll();
                ans[state.ind] = prod(state.val, 1);
            }
        }else{
            int full = k/n;
            int left = k%n;

            while(!que.isEmpty() && left-- > 0){
                State state = que.poll();
                long val = state.val;
                int ind = state.ind;

                ans[ind] = prod(prod(val, 1), pow(multiplier, full + 1));
            }
            while(!que.isEmpty()){
                State state = que.poll();
                long val = state.val;
                int ind = state.ind;

                ans[ind] =prod(prod(val, 1), pow(multiplier, full));
            }
        }

        return ans;
    }

    class State{
        int ind;
        long val;
        public State(int ind, long val){
            this.ind = ind;
            this.val = val;
        }
    }

    private int pow(long a, long b){
        if(a==0 || b == 1) return prod(a, 1);
        if(b==0) return 1;
        if(a==1) return 1;
        int p = pow(a,b/2);
        p = prod(p,p);
        if(b%2==1) p = prod(p, a);
        return p;

    }

    private int prod(long a, long b){
        long p = a * b;
        long mod = (long ) 1e9 + 7;
        return (int)(p%mod);
    }
}