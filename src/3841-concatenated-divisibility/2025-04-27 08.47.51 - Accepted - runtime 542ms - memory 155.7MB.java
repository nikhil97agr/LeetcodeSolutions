import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int[] concatenatedDivisibility(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans[] = new int[n];
        int max = (1<<n)-1;
        Boolean dp[][] = new Boolean[max+1][k];
        Queue<State> que = new LinkedList<>();
        que.offer(new State(0, 0, new Stack<>()));

        while(!que.isEmpty()){
            State state = que.poll();
            int rem = state.rem;
            int curr = state.currState;
            Stack<Integer> path = state.stack;

            if(rem ==0 && curr == max){
                for(int i=n-1;i>=0;i--){
                    ans[i] = path.pop();
                }
                return ans;
            }


            if(dp[curr][rem] !=null) continue;
            dp[curr][rem] = false;

            for(int i=0;i<n;i++){
                if((curr&(1<<i))==0){
                    int pow = (int)(Math.log(nums[i])/Math.log(10))+1;
                    int newRem = (rem*(int)Math.pow(10, pow) + nums[i])%k;

                    Stack<Integer> newPath = (Stack<Integer>) path.clone();

                    newPath.push(nums[i]);

                    que.offer(new State(newRem, curr | (1<<i), newPath));
                }
            }

        }

        return new int[0];
    }

    private boolean solve(int nums[], int k, int rem, Stack<Integer> stack, int n, Boolean dp[][], int currState, int maxState){

        if(currState == maxState){
            return rem == 0;
        }

        if(dp[currState][rem] !=null) return dp[currState][rem];

        for(int i=0;i<n;i++){
            if((currState&(1<<i))==0){
                int pow = (int)(Math.log(nums[i])/Math.log(10)) + 1;
                int temp = rem*(int)Math.pow(10, pow) + nums[i];
                temp%=k;

                stack.push(nums[i]);
                boolean res = solve(nums, k, temp, stack, n, dp, currState | (1<<i), maxState);
                if(res){
                    return true;
                }

                stack.pop();
            }
        }
        return false;
    }

    class State{
        int rem;
        int currState;
        Stack<Integer> stack;
        public State(int rem, int currState, Stack<Integer> stack){

            this.rem = rem;
            this.currState = currState;
            this.stack = stack;


        }
    }
}