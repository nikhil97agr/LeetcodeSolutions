class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
    
        int m = capacity.length;
        int n = apple.length;
        int cnt = 0;
        int total = 0;
        for(int i=0;i<n;i++){
            total += apple[i];
        }
        for(int j=m-1;j>=0;j--){
            if(total <= capacity[j]){
                cnt++;
                return cnt;
            }
            total -= capacity[j];
            cnt++;
        }
        
        return cnt;
    }
}