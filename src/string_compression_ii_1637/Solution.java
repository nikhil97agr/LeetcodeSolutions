package string_compression_ii_1637;

class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        Integer dp[][][][] = new Integer[n+1][k+1][26][n+1];

        return solve(s, 0, k, n, dp, ' ', 0);        
    }

    private int solve(String s, int i, int k, int n, Integer [][][][]dp, char curr, int currCount){

        if(k<0) return 10000000;

        if(i==n) return 0;

        if(curr != ' ' && dp[i][k][curr-'a'][currCount]!=null) return dp[i][k][curr-'a'][currCount];


        int ans = 0;

        if(s.charAt(i)==curr){
            int incr = 0;
            if(currCount == 1 || currCount == 9 || currCount == 99){
                incr= 1;
            }

            ans = incr + solve(s, i+1, k, n, dp, curr, currCount + 1 );
        }else{
            ans = Math.min(1+solve(s, i+1, k, n, dp, s.charAt(i), 1), solve(s, i+1, k-1, n, dp, curr, currCount));
        }
        if(curr!=' '){
            dp[i][k][curr-'a'][currCount] = ans;
        }
        return ans;
    }





    class State{
        int i;
        int k;
        char ch;
        int prevCount;

        public State(int i, int k, char ch, int prevCount){
            this.i = i;
            this.k = k;
            this.ch = ch;
            this.prevCount = prevCount;
        }

        public boolean equals(Object obj){
            State state = (State)obj;
            return state.i == i && state.k == k && state.ch == ch && state.prevCount == prevCount;
        }

        public int hashCode(){
            return (""+i+":"+k+":"+ch+":"+prevCount).hashCode();
        }
    }
}