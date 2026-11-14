class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = Arrays.stream(rolls).sum();
        int cnt = n+m;

        int left = mean*cnt - total;
        if(left > n*6 || left < n*1) return new int[0];
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            if(left >6){
                ans[i] = 6;
                left-=6;
            }else{
                ans[i] = left;
                left = 0;
                break;
            }
        }
        if(left > 0) return new int[0];
        int i=0;
        int j = n-1;

        while(j>=0 && ans[j] ==0 && i < n){
            if(ans[i] == 1){
                i++;
                continue;
            }
            else{
                ans[i]--;
                ans[j--] = 1;
            }
        }
        return ans;
    }
}