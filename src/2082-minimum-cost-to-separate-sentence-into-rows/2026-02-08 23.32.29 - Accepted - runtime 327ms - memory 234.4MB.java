class Solution {
    Integer dp[][];
    public int minimumCost(String sentence, int k) {
        
        List<Integer> list = Arrays.stream(sentence.split(" ")).map(s -> s.length()).toList();
        dp = new Integer[list.size()][k+1];
        return solve(0, 0, list.size(), list, k);
    }

    private int solve(int ind, int prevLength, int n, List<Integer> list, int k){
        if(prevLength > k){
            return Integer.MAX_VALUE;
        }
        if(ind == n) return 0;
        if(dp[ind][prevLength] !=null) return dp[ind][prevLength];
        int newLength = (prevLength == 0 ? prevLength : (prevLength + 1));
        int a = solve(ind + 1, newLength + list.get(ind), n, list, k);
        int b = solve(ind +1, list.get(ind), n, list, k);
        if(b != Integer.MAX_VALUE){
            b += Math.pow((k - prevLength), 2);
        }

        return dp[ind][prevLength] = Math.min(a, b);
    }
}