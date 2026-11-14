class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int t[] : transactions){
            int send = t[0];
            int receive = t[1];
            int amt =t[2];

            map.put(send, map.getOrDefault(send, 0)-amt);
            map.put(receive, map.getOrDefault(receive, 0)+amt);
        }

        return solve(map.values().stream().filter(a->a!=0).collect(Collectors.toList()) , 0);
    }

    private int solve(List<Integer> balance, int curr){
        while(curr < balance.size() && balance.get(curr)==0) curr++;
        if(curr==balance.size()){
            return 0;
        }
        int ans = 5000;
        for(int i=curr+1;i<balance.size();i++){
            int currAmt = balance.get(curr);
            int nextAmt = balance.get(i);

            if(currAmt*nextAmt<0){
                balance.set(i , nextAmt + currAmt);
                ans = Math.min(ans, 1 + solve(balance, curr+1));
                balance.set(i,nextAmt);
            }

            
        }

        return ans;
    }

}