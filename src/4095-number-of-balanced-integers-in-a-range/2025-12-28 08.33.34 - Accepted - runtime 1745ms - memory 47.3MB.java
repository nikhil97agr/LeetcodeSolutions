import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public long countBalanced(long low, long high) {
        long a = solve(Long.toString(high).toCharArray(), 0, 1, 0, 0, new HashMap<>());
        long b = solve(Long.toString(low - 1).toCharArray(), 0, 1, 0, 0, new HashMap<>());

        return a- b;
    }

    private long solve(char dig[],  int len, int flag, int sum, int i, Map<State, Long> dp){
        if(i == dig.length){

            if(len <= 1){
                return 0;
            }
            if(sum ==0) return 1;
            return 0;
        }
        State key = new State(len, flag, sum, i);
        if(dp.containsKey(key)) return dp.get(key);
        long ans = 0;
        if(flag == 1){
            int d1 = dig[i] - '0';
            for(int d=0;d<d1;d++){
                if(len ==0){
                    if(d==0){
                        ans += solve(dig, len, 0, sum, i+1, dp);
                    }else{
                        ans += solve(dig, len + 1, 0, sum -d, i+1, dp);
                    }
                    continue;
                }

                ans += solve(dig, len + 1, 0, sum + (len%2==0 ? -d : d), i+1, dp);
            }


            if(len ==0){
                if(d1==0){
                    ans += solve(dig, len, 1, sum, i+1, dp);
                }else{
                    ans += solve(dig, len + 1, 1, sum -d1, i+1, dp);
                }

            }else{
                ans += solve(dig, len + 1, 1, sum + (len%2==0 ? -d1 : d1), i+1, dp);
            }




        }else{
            for(int d=0;d<=9;d++){
                if(len ==0){
                    if(d==0){
                        ans += solve(dig, len, flag, sum, i+1, dp);
                    }else{
                        ans += solve(dig, len + 1, flag, sum -d, i+1, dp);
                    }
                    continue;
                }

                ans += solve(dig, len + 1, flag, sum + (len%2==0 ? -d : d), i+1, dp);
            }
        }

        dp.put(key, ans);
        return ans;
    }

    class State{
        int len;
        int flag;
        int sum;
        int i;
        public State(int len, int flag, int sum, int i){
            this.len = len;
            this.flag=  flag;
            this.sum = sum;
            this.i = i;
        }

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return len == state.len && flag == state.flag && sum == state.sum && i == state.i;
        }

        @Override
        public int hashCode() {

            return Objects.hash(len, flag, sum, i);
        }
    }
}