class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int cnt = 0;
        int n = tickets.length;
        for(int i=0;i<n;i++){
            if(tickets[i] >= tickets[k]){
                if(i<=k){
                    cnt += tickets[k];
                }else{
                    cnt += tickets[k] - 1;
                }
            }else{
                cnt += tickets[i];
            }
        }
        return cnt;
    }


}